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
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.webkit.WebViewAssetLoader
import androidx.webkit.WebViewClientCompat
import dagger.hilt.android.AndroidEntryPoint
import hu.kristof.nagy.mathapp.R
import hu.kristof.nagy.mathapp.data.entity.Exercise
import hu.kristof.nagy.mathapp.viewmodel.exercise.ExerciseEditViewModel

@AndroidEntryPoint
class ExerciseEditFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_exercise_edit, container, false)

        val webView = view.findViewById<WebView>(R.id.exercise_web_view)

        val assetLoader = WebViewAssetLoader.Builder()
            .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(requireContext()))
            .build()
        webView.webViewClient = object : WebViewClientCompat() {
            @RequiresApi(21)
            override fun shouldInterceptRequest(
                view: WebView?,
                request: WebResourceRequest
            ): WebResourceResponse? {
                return assetLoader.shouldInterceptRequest(request.url)
            }
        }
        webView.settings.apply {
            allowFileAccess = false
            allowContentAccess = false
            javaScriptEnabled = true
        }

        val viewModel: ExerciseEditViewModel by viewModels()
        val args: ExerciseEditFragmentArgs by navArgs()
        val navController = findNavController()
        webView.apply {
            addJavascriptInterface(
                WebAppInterface(
                    requireContext(),
                    navController,
                    viewModel,
                    args.exercise
                ), "ExerciseEditInterface")
            loadUrl("https://appassets.androidplatform.net/assets/exerciseEdit/exerciseEdit.html")
        }

        return view
    }

    class WebAppInterface(
        private val context: Context,
        private val navController: NavController,
        private val viewModel: ExerciseEditViewModel,
        private val exercise: Exercise
    ) {
        @JavascriptInterface
        fun saveEdit(name: String, question: String, answer: String) {
            viewModel.edit(exercise, name, question, answer)
            val directions = ExerciseEditFragmentDirections
                .actionExerciseEditFragmentToBrowseFragment(exercise.parentTopicId)
            navController.navigate(directions)
        }

        @JavascriptInterface
        fun showToast(str: String) {
            Toast.makeText(context, str, Toast.LENGTH_LONG).show()
        }

        @JavascriptInterface
        fun getExerciseQuestion(): String = exercise.question

        @JavascriptInterface
        fun getExerciseAnswer(): String = exercise.answer

        @JavascriptInterface
        fun getExerciseName(): String = exercise.name
    }
}