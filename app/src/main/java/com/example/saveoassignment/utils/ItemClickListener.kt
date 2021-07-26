package com.example.saveoassignment.utils

import com.example.saveoassignment.data.model.MoviesResponseItem

interface ItemClickListener {
    fun onItemClicked(moviesItem : MoviesResponseItem)

}