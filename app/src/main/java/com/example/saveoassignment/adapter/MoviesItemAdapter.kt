package com.example.saveoassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saveoassignment.R
import com.example.saveoassignment.data.model.MoviesResponseItem
import com.example.saveoassignment.utils.ItemClickListener
import com.example.saveoassignment.viewholder.MoviesItemViewHolder

class MoviesItemAdapter(val moviesList: MutableList<MoviesResponseItem?>?, val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<MoviesItemViewHolder>() {

    /*
    Inflates the layout and sends it to the view holders constructor.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movies_list_item_layout, parent, false)
        return MoviesItemViewHolder(view,itemClickListener)
    }
/*

Binds the movies data with the view holder
 */
    override fun onBindViewHolder(holder: MoviesItemViewHolder, position: Int) {
        var moviesResponseItem = moviesList?.get(position)
        if (moviesResponseItem != null) {
            holder.setData(moviesResponseItem)
        }
    }

    /*

    checks the list of data and reurns the size
     */
    override fun getItemCount(): Int {
        return moviesList?.size!!
    }


}