package com.example.saveoassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.saveoassignment.R
import com.example.saveoassignment.data.model.MoviesResponseItem
import com.example.saveoassignment.viewholder.MoviesItemViewHolder
import com.example.saveoassignment.viewholder.SliderItemViewHolder

class MoviesItemAdapter(val moviesList: MutableList<MoviesResponseItem?>?) :
    RecyclerView.Adapter<MoviesItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movies_list_item_layout, parent, false)
        return MoviesItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesItemViewHolder, position: Int) {
        var moviesResponseItem = moviesList?.get(position)
        if (moviesResponseItem != null) {
            holder.setData(moviesResponseItem)
        }
    }

    override fun getItemCount(): Int {
        return moviesList?.size!!
    }


}