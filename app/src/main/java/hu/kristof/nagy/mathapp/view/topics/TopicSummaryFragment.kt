package hu.kristof.nagy.mathapp.view.topics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.webkit.WebViewAssetLoader
import androidx.webkit.WebViewClientCompat
import dagger.hilt.android.AndroidEntryPoint
import hu.kristof.nagy.mathapp.R
import hu.kristof.nagy.mathapp.viewmodel.topic.TopicSummaryViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopicSummaryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_topic_summary, container, false)

        val webView = view.findViewById<WebView>(R.id.topic_summary_web_view)

        val args: TopicSummaryFragmentArgs by navArgs()
        val viewModel: TopicSummaryViewModel by viewModels()
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
                    viewModel,
                    webView,
                    viewLifecycleOwner,
                    lifecycleScope
                ),
                "TopicSummaryInterface"
            )
            loadUrl("https://appassets.androidplatform.net/assets/topicSummary/topicSummary.html")
        }

        return view
    }

    class WebAppInterface(
        private val viewModel: TopicSummaryViewModel,
        private val webView: WebView,
        private val lifecycleOwner: LifecycleOwner,
        private val scope: CoroutineScope
    ) {
        @JavascriptInterface
        fun setSummary() {
            scope.launch {
                viewModel.topic.observe(lifecycleOwner) { topic ->
                    webView.post {
                        // Note: if the summary is $x = 3$, then
                        // with "let x = '${summary}'", JS will throw
                        // an error, because it probably interprets '${summary}'
                        // as a statement instead of a string.
                        // "let x = \'${summary}\'" will also not work, but
                        // "let x = \"${summary}\"" is okay.
                        webView.evaluateJavascript(
                            "let summary = \"${topic.summary}\";" +
                                    "let output = document.getElementById(\"output\");" +
                                    "convertOnLoad(summary, output, 'TopicSummaryInterface');", null
                        )
                    }
                }
            }
        }
    }
}