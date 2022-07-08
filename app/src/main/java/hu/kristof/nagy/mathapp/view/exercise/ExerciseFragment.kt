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
import androidx.navigation.fragment.navArgs
import androidx.webkit.WebViewAssetLoader
import androidx.webkit.WebViewClientCompat
import hu.kristof.nagy.mathapp.data.entity.Exercise
import hu.kristof.nagy.mathapp.databinding.FragmentExerciseBinding


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
        binding.exerciseWebView.apply {
            addJavascriptInterface(
                WebAppInterface(requireContext(), args.exercise),
                "ExerciseInterface"
            )
            loadUrl("https://appassets.androidplatform.net/assets/exercise.html")
        }

        return binding.root
    }

    class WebAppInterface(
        private val context: Context,
        val exercise: Exercise
    ) {
        @JavascriptInterface
        fun showToast(str: String) {
            Toast.makeText(context, str, Toast.LENGTH_LONG).show()
        }

        @JavascriptInterface
        fun getExerciseQuestion(): String = exercise.question

        @JavascriptInterface
        fun getExerciseName(): String = exercise.name

        @JavascriptInterface
        fun getExerciseAnswer(): String = exercise.answer
    }
}