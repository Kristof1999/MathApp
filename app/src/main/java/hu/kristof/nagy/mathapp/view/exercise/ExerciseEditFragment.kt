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
import hu.kristof.nagy.mathapp.data.entity.Exercise
import hu.kristof.nagy.mathapp.databinding.FragmentExerciseEditBinding

class ExerciseEditFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentExerciseEditBinding.inflate(
            inflater, container, false
        )

        val assetLoader = WebViewAssetLoader.Builder()
            .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(requireContext()))
            .build()
        binding.exerciseEditWebView.webViewClient = object : WebViewClientCompat() {
            @RequiresApi(21)
            override fun shouldInterceptRequest(
                view: WebView?,
                request: WebResourceRequest
            ): WebResourceResponse? {
                return assetLoader.shouldInterceptRequest(request.url)
            }
        }
        binding.exerciseEditWebView.settings.apply {
            allowFileAccess = false
            allowContentAccess = false
            javaScriptEnabled = true
        }

        val navController = findNavController()
        binding.exerciseEditWebView.apply {
            addJavascriptInterface(
                ExerciseCreateFragment.WebAppInterface(
                    requireContext(),
                    navController,
                ), "ExerciseCreateInterface")
            loadUrl("https://appassets.androidplatform.net/assets/exerciseEdit/exerciseEdit.html")
        }

        return binding.root
    }

    class WebAppInterface(
        private val context: Context,
        private val navController: NavController,
        private val exercise: Exercise
    ) {
        @JavascriptInterface
        fun saveEdit(name: String, question: String, answer: String) {

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