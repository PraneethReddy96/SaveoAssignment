package com.example.saveoassignment.viewholder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.saveoassignment.R
import com.example.saveoassignment.data.model.MoviesResponseItem
import com.makeramen.roundedimageview.RoundedImageView

class MoviesItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var sliderImage = view.findViewById<ImageView>(R.id.ivMoviesImageView)

    fun setData(moviesResponseItem: MoviesResponseItem) {

        Glide.with(sliderImage).load(moviesResponseItem.image?.original)
            .placeholder(R.drawable.ic_loupe__2_).into(sliderImage)

    }


}