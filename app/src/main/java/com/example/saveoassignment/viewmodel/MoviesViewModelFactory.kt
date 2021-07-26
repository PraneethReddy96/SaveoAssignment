package com.example.saveoassignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.saveoassignment.repository.Repository

/*
It is used in conjunction with view model.
 */
class MoviesViewModelFactory(val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return MoviesViewModel(repository) as T
    }
}