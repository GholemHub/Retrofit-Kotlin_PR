package com.example.getpost_retrofit_pr

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.getpost_retrofit_pr.repository.Repository

class MainViewModelFactory(
    private val repositpry: Repository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repositpry) as T
    }
}