package com.example.paginationdemo.example.fragment

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.paginationdemo.R
import com.example.paginationdemo.example.NewsActivity
import com.example.paginationdemo.example.NewsViewModel

import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}
//class ArticleFragment : Fragment(R.layout.fragment_article) {
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val article = arguments?.getSerializable("article") as? Article
//
//        if (article != null) {
//            val webView: WebView = view.findViewById(R.id.webView)
//            if (!article.url.isNullOrEmpty()) {
//                webView.apply {
//                    webViewClient = WebViewClient()
//                    loadUrl(article.url)
//                }
//            } else {
//                Toast.makeText(context, "URL is invalid", Toast.LENGTH_SHORT).show()
//            }
//        } else {
//            Toast.makeText(context, "Article not found", Toast.LENGTH_SHORT).show()
//        }
//    }
//}
