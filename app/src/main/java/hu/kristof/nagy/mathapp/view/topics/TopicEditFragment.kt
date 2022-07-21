package hu.kristof.nagy.mathapp.view.topics

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
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.webkit.WebViewAssetLoader
import androidx.webkit.WebViewClientCompat
import dagger.hilt.android.AndroidEntryPoint
import hu.kristof.nagy.mathapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopicEditFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_topic_edit, container, false)

        // maybe try using only this in other cases too (ExerciseFragment, ...)
        // instead of data binding
        val webView = view.findViewById<WebView>(R.id.topic_edit_web_view)
        val args: TopicEditFragmentArgs by navArgs()
        val viewModel: TopicEditViewModel by viewModels()
        val navController = findNavController()
        viewModel.loadTopic(args.topicId)

        val assetLoader = WebViewAssetLoader.Builder()
            .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(requireContext()))
            .build()
        webView.webViewClient = object : WebViewClientCompat() {

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
        webView.apply {
            addJavascriptInterface(
                WebAppInterface(
                    requireContext(),
                    navController,
                    viewModel,
                    viewLifecycleOwner,
                    webView,
                    lifecycleScope,
                    args.parentTopicId
                ),
                "TopicEditInterface"
            )
            loadUrl("https://appassets.androidplatform.net/assets/topicEdit/topicEdit.html")
        }

        return view
    }

    class WebAppInterface(
        private val context: Context,
        private val navController: NavController,
        private val viewModel: TopicEditViewModel,
        private val lifecycleOwner: LifecycleOwner,
        private val webView: WebView,
        private val scope: CoroutineScope,
        private val parentTopicId: Long
    ) {
        @JavascriptInterface
        fun setName() {
            scope.launch {
                viewModel.topic.observe(lifecycleOwner) { topic ->
                    webView.post {
                        webView.evaluateJavascript(
                            "let nameElement = document.getElementById('topicName');" +
                                    "nameElement.value = '${topic.topicName}';", null
                        )
                    }
                }
            }
        }

        @JavascriptInterface
        fun setSummary() {
            scope.launch {
                viewModel.topic.observe(lifecycleOwner) { topic ->
                    webView.post {
                        webView.evaluateJavascript(
                            "let summaryElement = document.getElementById('input');" +
                                    "summaryElement.value = '${topic.summary}';", null
                        )
                    }
                }
            }
        }

        @JavascriptInterface
        fun save(name:String, summary: String) {
            scope.launch {
                viewModel.topic.observe(lifecycleOwner) { topic ->
                    viewModel.save(topic, name, summary)
                    val directions = TopicEditFragmentDirections
                        .actionTopicEditFragmentToBrowseFragment(topic.parentTopicName, parentTopicId)
                    navController.navigate(directions)
                }
            }
        }

        @JavascriptInterface
        fun showToast(str: String) {
            Toast.makeText(context, str, Toast.LENGTH_LONG).show()
        }
    }
}