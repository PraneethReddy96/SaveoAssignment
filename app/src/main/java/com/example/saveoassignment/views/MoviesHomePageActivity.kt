package com.example.saveoassignment.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.saveoassignment.R
import com.example.saveoassignment.adapter.MoviesItemAdapter
import com.example.saveoassignment.adapter.SliderItemAdapter
import com.example.saveoassignment.data.model.MoviesResponseItem
import com.example.saveoassignment.repository.Repository
import com.example.saveoassignment.viewmodel.MoviesViewModel
import com.example.saveoassignment.viewmodel.MoviesViewModelFactory
import kotlinx.android.synthetic.main.activity_movies_home_page.*

class MoviesHomePageActivity : AppCompatActivity() {

    var moviesList: MutableList<MoviesResponseItem?>? = mutableListOf()
    lateinit var viewPager: ViewPager2
    lateinit var viewModel: MoviesViewModel
    var moviesAdapter = MoviesItemAdapter(moviesList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_home_page)
        initViewsAndSetViewPager()
        setMoviesRecyclerAdapter()
        buildData()

    }

    private fun buildData() {
        viewModel.getMoviesList(1).observe(this, Observer {

            moviesList!!.clear()
            moviesList!!.addAll(it!!)
            viewPager.adapter?.notifyDataSetChanged()
            rvHomeScreenMovies.adapter?.notifyDataSetChanged()


        })
    }

    private fun setMoviesRecyclerAdapter() {
        val ltManager = GridLayoutManager(this, 3)
        rvHomeScreenMovies.adapter = moviesAdapter
        rvHomeScreenMovies.layoutManager= ltManager

    }

    private fun initViewsAndSetViewPager() {
        val repository = Repository()
        val viewModelFactory = MoviesViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MoviesViewModel::class.java)

// setting view pager //
        viewPager = findViewById<ViewPager2>(R.id.vpHomeScreenMoviesSlider)
        viewPager.adapter = SliderItemAdapter(moviesList, viewPager)

        viewPager.clipToPadding =false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3
        viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(10))
        compositePageTransformer.addTransformer(ViewPager2.PageTransformer { page, position ->

            val r: Float = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.15f
        })

        viewPager.setPageTransformer(compositePageTransformer)
    }


}

