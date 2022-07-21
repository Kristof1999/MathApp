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
import hu.kristof.nagy.mathapp.viewmodel.exercise.ExerciseCreateViewModel

@AndroidEntryPoint
class ExerciseCreateFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_exercise_create, container, false)

        val webView = view.findViewById<WebView>(R.id.exercise_create_web_view)

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

        val exerciseCreateViewModel: ExerciseCreateViewModel by viewModels()
        val args: ExerciseCreateFragmentArgs by navArgs()
        val navController = findNavController()
        webView.apply {
            addJavascriptInterface(
                WebAppInterface(
                requireContext(),
                navController,
                exerciseCreateViewModel,
                args.parentTopicId
            ), "ExerciseCreateInterface")
            loadUrl("https://appassets.androidplatform.net/assets/exerciseCreate/exerciseCreate.html")
        }

        return view
    }

    class WebAppInterface(
        private val context: Context,
        private val navController: NavController,
        private val exerciseCreateViewModel: ExerciseCreateViewModel,
        private val parentTopicId: Long
    ) {
        @JavascriptInterface
        fun createExercise(name: String, question: String, answer: String) {
            exerciseCreateViewModel.create(name, question, answer, parentTopicId)

            val directions = ExerciseCreateFragmentDirections
                .actionExerciseCreateFragmentToBrowseFragment(parentTopicId)
            navController.navigate(directions)
        }

        @JavascriptInterface
        fun showToast(str: String) {
            Toast.makeText(context, str, Toast.LENGTH_LONG).show()
        }
    }
}