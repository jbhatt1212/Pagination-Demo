package com.example.paginationdemo.example

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.paginationdemo.R
import com.example.paginationdemo.example.adapter.NewsAdapter
import com.example.paginationdemo.example.db.ArticleDatabase
import com.example.paginationdemo.example.fragment.ArticleFragment
import com.example.paginationdemo.example.fragment.SavedNewsFragment
import com.example.paginationdemo.example.fragment.SearchNewsFragment
import com.example.paginationdemo.example.models.Article
import com.example.paginationdemo.example.repository.NewsRepository
import com.example.paginationdemo.example.util.Resource
import com.google.android.material.bottomnavigation.BottomNavigationView


class NewsActivity : AppCompatActivity() {
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  enableEdgeToEdge()
        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        setContentView(R.layout.activity_news)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val newsNavHostFragment = supportFragmentManager
            .findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = newsNavHostFragment.navController

        // Initialize ViewModel


        // Set up BottomNavigationView with NavController
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)
    }
    }

//
//        bottomNavigationView = findViewById(R.id.bottomNavigationView)
//        val newsRepository = NewsRepository(ArticleDatabase(this))
//        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
//        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
//        bottomNavigationView.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.searchNewsFragment -> navigateToSearchNewsFragment()
//                R.id.savedNewsFragment -> navigateToSavedFragment()
//            }
//            true
//        }
//

    // Observe breaking news
//        viewModel.breakingNews.observe(this) { resource ->
//            when (resource) {
//                is Resource.Success -> {
//                    val article = resource.data?.articles?.firstOrNull()
//                    article?.let {
//                        navigateToArticleFragment(it)
//                    }
//                }
//
//                is Resource.Error -> {
//                    Toast.makeText(this, "Error fetching articles", Toast.LENGTH_SHORT).show()
//                }
//
//                is Resource.Loading -> {
//                    // Optionally handle loading state
//                }
//            }
//        }
//
//    }

//    private fun navigateToArticleFragment(article: Article) {
//        val fragment = ArticleFragment().apply {
//            arguments = Bundle().apply {
//                putSerializable("article", article)
//            }
//        }
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.newsNavHostFragment, fragment)
//            .addToBackStack(null)
//            .commit()
//    }
//
//    private fun navigateToSearchNewsFragment() {
//        val fragment = SearchNewsFragment()
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.newsNavHostFragment, fragment)
//            .addToBackStack(null)
//            .commit()
//    }
//    private fun navigateToSavedFragment(){
//        val fragment = SavedNewsFragment()
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.newsNavHostFragment,fragment)
//            .addToBackStack(null)
//            .commit()
//    }







