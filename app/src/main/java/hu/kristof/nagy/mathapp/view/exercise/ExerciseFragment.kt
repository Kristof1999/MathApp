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
import hu.kristof.nagy.mathapp.R
import hu.kristof.nagy.mathapp.data.entity.Exercise
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
            @RequiresApi(21)
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
                    binding.exerciseWebView
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
        private val exerciseWebView: WebView
    ) {
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
                    .actionExerciseFragmentToDetailListFragment(exercise.parentTopicName)
                navController.navigate(directions)
            } else {
                showToast("Rossz válasz!")
            }
        }

        @JavascriptInterface
        fun selectStep(stepType: String, prevStep: String) {
            val parsedStep = LatexParser.parse(prevStep)
            when (stepType) {
                "leftOrder" -> {
                    val transformedStep = LeftOrder.transform(parsedStep, null).toLatex()
                    addStep(transformedStep)
                }
                "rightOrder" -> {
                    val transformedStep = RightOrder.transform(parsedStep, null).toLatex()
                    addStep(transformedStep)
                }
                "addBothSide" -> {
                    transformStepByX(AddBothSideByX, parsedStep)
                }
                "subtractBothSide" -> {
                    transformStepByX(SubtractBothSideByX, parsedStep)
                }
                "multiplyBothSide" -> {
                    transformStepByX(MultiplyBothSideByX, parsedStep)
                }
                "divideBothSide" -> {
                    transformStepByX(DivideBothSideByX, parsedStep)
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
                    val transformedStep = transformer.transform(parsedStep, parsedX).toLatex()
                    addStep(transformedStep)
                }
            }
        }

        private fun addStep(transformedStep: String) {
            exerciseWebView.post {
                exerciseWebView.evaluateJavascript(
                    "addStep('$transformedStep')", null
                )
            }
        }
    }
}