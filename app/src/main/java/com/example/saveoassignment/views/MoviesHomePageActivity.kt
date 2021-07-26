package com.example.saveoassignment.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
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
import com.example.saveoassignment.utils.ItemClickListener
import com.example.saveoassignment.viewmodel.MoviesViewModel
import com.example.saveoassignment.viewmodel.MoviesViewModelFactory
import kotlinx.android.synthetic.main.activity_movies_home_page.*

class MoviesHomePageActivity : AppCompatActivity(),ItemClickListener {

    private var moviesList: MutableList<MoviesResponseItem?>? = mutableListOf()
    private lateinit var viewPager: ViewPager2
    private lateinit var viewModel: MoviesViewModel
    private var moviesAdapter = MoviesItemAdapter(moviesList,this)
    private var currentPage : Int = 1
    private var totalAvailablePages : Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_home_page)
        initViewsAndSetViewPager()
        setMoviesRecyclerAdapter()
        buildData()

    }

    private fun buildData() {
        viewModel.getMoviesList(currentPage).observe(this, Observer {

            moviesList!!.clear()
            moviesList!!.addAll(it!!)
            viewPager.adapter?.notifyDataSetChanged()
           rvHomeScreenMovies.adapter?.notifyDataSetChanged()


        })
    }

    private fun setMoviesRecyclerAdapter() {

        rvHomeScreenMovies.apply {

            val ltManager = GridLayoutManager(this@MoviesHomePageActivity, 3)
            adapter = moviesAdapter
            layoutManager = ltManager

        }

        fun RecyclerView.onScrollToEnd(
            onScrollNearEnd: (Unit) -> Unit
        ) = addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!rvHomeScreenMovies.canScrollVertically(1)) {
                    onScrollNearEnd(Unit)
                    currentPage+=1
                    buildData()
                }
            }
        })
    }

    private fun initViewsAndSetViewPager() {
        val repository = Repository()
        val viewModelFactory = MoviesViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MoviesViewModel::class.java)

        // setting view pager to its recyclerview adapter //
        viewPager = findViewById<ViewPager2>(R.id.vpHomeScreenMoviesSlider)
        viewPager.adapter = SliderItemAdapter(moviesList, viewPager,this)

        viewPager.clipToPadding = false
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

    override fun onItemClicked(moviesItem: MoviesResponseItem) {


        val intent = Intent(this,PreviewActivity::class.java)
        intent.putExtra("image",moviesItem.image?.original.toString())
        intent.putExtra("title",moviesItem.name.toString())
        intent.putExtra("summary",moviesItem.summary.toString())
        intent.putExtra("time",moviesItem.averageRuntime.toString())
        intent.putExtra("date",moviesItem.premiered.toString())
        intent.putExtra("type",moviesItem.type.toString())
        startActivity(intent)

    }


}

