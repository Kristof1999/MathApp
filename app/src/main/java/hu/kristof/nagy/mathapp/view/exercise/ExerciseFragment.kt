package hu.kristof.nagy.mathapp.view.exercise

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.coroutineScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.webkit.WebViewAssetLoader
import androidx.webkit.WebViewClientCompat
import com.google.android.material.snackbar.Snackbar
import hu.kristof.nagy.mathapp.R
import hu.kristof.nagy.mathapp.data.entity.Exercise
import hu.kristof.nagy.mathapp.data.entity.Topic
import hu.kristof.nagy.mathapp.databinding.FragmentExerciseBinding
import hu.kristof.nagy.mathapp.view.TextDialogFragment
import hu.kristof.nagy.mathapp.view.step.LatexParser
import hu.kristof.nagy.mathapp.view.step.model.Expression
import hu.kristof.nagy.mathapp.view.step.transform.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class ExerciseFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentExerciseBinding.inflate(
            inflater, container, false
        )

        val args: ExerciseFragmentArgs by navArgs()

        val assetLoader = WebViewAssetLoader.Builder()
            .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(requireContext()))
            .build()
        binding.exerciseWebView.webViewClient = object : WebViewClientCompat() {
            override fun shouldInterceptRequest(
                view: WebView?,
                request: WebResourceRequest
            ): WebResourceResponse? {
                return assetLoader.shouldInterceptRequest(request.url)
            }
        }
        binding.exerciseWebView.settings.apply {
            allowFileAccess = false
            allowContentAccess = false
            javaScriptEnabled = true
        }
        val navController = findNavController()
        binding.exerciseWebView.apply {
            addJavascriptInterface(
                WebAppInterface(
                    requireContext(),
                    parentFragmentManager,
                    viewLifecycleOwner,
                    lifecycle.coroutineScope,
                    args.exercise,
                    navController,
                    binding.exerciseWebView,
                    args.topicId
                ),
                "ExerciseInterface"
            )
            loadUrl("https://appassets.androidplatform.net/assets/exercise/exercise.html")
        }

        return binding.root
    }

    class WebAppInterface(
        private val context: Context,
        private val fragmentManager: FragmentManager,
        private val lifecycleOwner: LifecycleOwner,
        private val scope: CoroutineScope,
        private val exercise: Exercise,
        private val navController: NavController,
        private val exerciseWebView: WebView,
        private val topicId: Long
    ) {
        private val steps = mutableListOf<Expression>()

        @JavascriptInterface
        fun showToast(str: String) {
            Toast.makeText(context, str, Toast.LENGTH_LONG).show()
        }

        @JavascriptInterface
        fun getExerciseQuestion(): String = exercise.question

        @JavascriptInterface
        fun checkAnswer(answer: String) {
            if (answer == exercise.answer) {
                showToast("Jó válasz!")
                val directions = ExerciseFragmentDirections
                    .actionExerciseFragmentToBrowseFragment(exercise.parentTopicName)
                navController.navigate(directions)
            } else {
                showToast("Rossz válasz!")
            }
        }

        @JavascriptInterface
        fun reviewTheory() {
            // maybe disable/hide the button instead of this
            if (topicId == 0L) {
                return
            }
            val directions = ExerciseFragmentDirections
                .actionExerciseFragmentToTopicSummaryFragment(topicId)
            navController.navigate(directions)
        }

        @JavascriptInterface
        fun setFirstStep() {
            val question = exercise.question
            if (question.count { c -> c == '$'} > 1) {
                //ask user which math block should we use?
            }
            val mathBlockStartIdx = question.indexOf('$')
            val mathBlockEndIdx = question.indexOf('$', mathBlockStartIdx + 1)
            val mathBlock = question.substring(mathBlockStartIdx + 1, mathBlockEndIdx)
            val parsedStep = LatexParser.parse(mathBlock)
            steps.add(parsedStep)
        }

        @JavascriptInterface
        fun selectStep(stepType: String) {
            val prevStep = steps[steps.size - 1]
            when (stepType) {
                "leftOrder" -> {
                    val transformedStep = LeftOrder.transform(prevStep, null)
                    addStep(transformedStep)
                }
                "rightOrder" -> {
                    val transformedStep = RightOrder.transform(prevStep, null)
                    addStep(transformedStep)
                }
                "addBothSide" -> {
                    transformStepByX(AddBothSideByX, prevStep)
                }
                "subtractBothSide" -> {
                    transformStepByX(SubtractBothSideByX, prevStep)
                }
                "multiplyBothSide" -> {
                    transformStepByX(MultiplyBothSideByX, prevStep)
                }
                "divideBothSide" -> {
                    transformStepByX(DivideBothSideByX, prevStep)
                }
                else -> throw IllegalArgumentException("Unknown stepType: $stepType")
            }
        }

        private fun transformStepByX(
            transformer: StepTransformer,
            parsedStep: Expression
        ) {
            val xDialog = TextDialogFragment.instanceOf(
                R.string.xText, R.string.xHint
            )
            xDialog.show(fragmentManager, "x")
            scope.launch {
                xDialog.text.observe(lifecycleOwner) { x ->
                    val parsedX = LatexParser.parse(x)
                    // TODO: handle errors and edge cases
                    val transformedStep = transformer.transform(parsedStep, parsedX)
                    addStep(transformedStep)
                }
            }
        }

        private fun addStep(transformedStep: Expression) {
            steps.add(transformedStep)
            exerciseWebView.post {
                exerciseWebView.evaluateJavascript(
                    "addStep(\"${transformedStep.toLatex()}\")", null
                )
            }
        }
    }
}