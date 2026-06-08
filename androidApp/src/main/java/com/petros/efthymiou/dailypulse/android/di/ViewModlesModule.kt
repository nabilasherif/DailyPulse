package com.petros.efthymiou.dailypulse.android.di

import com.petros.efthymiou.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// construct koin to find dependency from dependency graph
val viewModelsModule = module{
    viewModel { ArticlesViewModel(get()) }
}