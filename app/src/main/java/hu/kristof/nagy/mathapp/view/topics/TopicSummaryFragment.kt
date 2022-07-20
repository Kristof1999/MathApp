package hu.kristof.nagy.mathapp.view.topics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.webkit.WebViewAssetLoader
import androidx.webkit.WebViewClientCompat
import hu.kristof.nagy.mathapp.R
import hu.kristof.nagy.mathapp.data.entity.Topic

class TopicSummaryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_topic_summary, container, false)

        val webView = view.findViewById<WebView>(R.id.topic_summary_web_view)

        val args: TopicSummaryFragmentArgs by navArgs()

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
                WebAppInterface(args.topic),
                "TopicSummaryInterface"
            )
            loadUrl("https://appassets.androidplatform.net/assets/topicSummary/topicSummary.html")
        }

        return view
    }

    class WebAppInterface(
        private val topic: Topic
    ) {
        @JavascriptInterface
        fun getSummary(): String = topic.summary
    }
}