package hu.kristof.nagy.mathapp.view.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.webkit.WebViewAssetLoader
import androidx.webkit.WebViewClientCompat
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
        binding.exerciseName.text = args.exercise.name

        val assetLoader = WebViewAssetLoader.Builder()
            .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(requireContext()))
            .build()
        binding.exerciseQuestionWebView.webViewClient = object : WebViewClientCompat() {
            @RequiresApi(21)
            override fun shouldInterceptRequest(
                view: WebView?,
                request: WebResourceRequest
            ): WebResourceResponse? {
                return assetLoader.shouldInterceptRequest(request.url)
            }
        }
        binding.exerciseQuestionWebView.settings.apply {
            allowFileAccess = false
            allowContentAccess = false
            javaScriptEnabled = true
        }
        binding.exerciseQuestionWebView
            .loadUrl("https://appassets.androidplatform.net/assets/index.html")

        return binding.root
    }
}