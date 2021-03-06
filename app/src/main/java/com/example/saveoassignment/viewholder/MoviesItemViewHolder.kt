package com.example.saveoassignment.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.saveoassignment.R
import com.example.saveoassignment.data.model.MoviesResponseItem
import com.example.saveoassignment.utils.ItemClickListener

class MoviesItemViewHolder(view: View,val itemClickListener: ItemClickListener) : RecyclerView.ViewHolder(view) {

    var sliderImage = view.findViewById<ImageView>(R.id.ivMoviesImageView)
    var llContainer = view.findViewById<LinearLayout>(R.id.llMoviesContainer)

   /*

   Sets the data into the view and view groups on receiving from adapter
    */
    fun setData(moviesResponseItem: MoviesResponseItem?) {

        Glide.with(sliderImage).load(moviesResponseItem?.image?.original)
            .placeholder(R.color.grey).into(sliderImage)

        llContainer.setOnClickListener(View.OnClickListener {

            itemClickListener.onItemClicked(moviesResponseItem!!)
        })


    }




}