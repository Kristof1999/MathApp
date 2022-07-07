package hu.kristof.nagy.mathapp.view.topics.detail

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
import hu.kristof.nagy.mathapp.databinding.FragmentExerciseCreateBinding

@AndroidEntryPoint
class ExerciseCreateFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentExerciseCreateBinding.inflate(
            inflater, container, false
        )

        val assetLoader = WebViewAssetLoader.Builder()
            .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(requireContext()))
            .build()
        binding.exerciseCreateWebView.webViewClient = object : WebViewClientCompat() {
            @RequiresApi(21)
            override fun shouldInterceptRequest(
                view: WebView?,
                request: WebResourceRequest
            ): WebResourceResponse? {
                return assetLoader.shouldInterceptRequest(request.url)
            }
        }
        binding.exerciseCreateWebView.settings.apply {
            allowFileAccess = false
            allowContentAccess = false
            javaScriptEnabled = true
        }

        val exerciseCreateViewModel: ExerciseCreateViewModel by viewModels()
        val args: ExerciseCreateFragmentArgs by navArgs()
        val navController = findNavController()
        binding.exerciseCreateWebView.apply {
            addJavascriptInterface(WebAppInterface(
                requireContext(),
                navController,
                exerciseCreateViewModel,
                args.parentTopicName
            ), "ExerciseCreateFragment")
            loadUrl("https://appassets.androidplatform.net/assets/exerciseCreate.html")
        }

        return binding.root
    }

    class WebAppInterface(
        private val context: Context,
        private val navController: NavController,
        private val exerciseCreateViewModel: ExerciseCreateViewModel,
        private val parentTopicName: String
    ) {
        @JavascriptInterface
        fun createExercise(name: String, question: String, answer: String) {
            exerciseCreateViewModel.create(name, question, answer, parentTopicName)

            val directions = ExerciseCreateFragmentDirections
                .actionExerciseCreateFragmentToDetailListFragment(parentTopicName)
            navController.navigate(directions)
        }

        @JavascriptInterface
        fun showToast(str: String) {
            Toast.makeText(context, str, Toast.LENGTH_LONG).show()
        }
    }
}