package com.example.mathapp.ui.exam.composable.Result

import androidx.lifecycle.ViewModel
import com.example.mathapp.data.exam.ProductsRepositoryImpl
import javax.inject.Inject

class ResultViewModel @Inject constructor(
    private val repository: ProductsRepositoryImpl
) : ViewModel() {

}