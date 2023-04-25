package com.example.mathapp.ui.exam

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.example.mathapp.ui.exam.model.ExamDataOrException
import com.example.mathapp.data.users.QuestionsModel
import com.example.mathapp.framework.exam.ProductsRepositoryImpl
import com.example.mathapp.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExamViewModel @Inject constructor(
    private val repository: ProductsRepositoryImpl
) : ViewModel() {

    private val _ldata = SingleLiveEvent<NavDirections>()
    val ldata: LiveData<NavDirections> = _ldata

    private var _quiz = MutableLiveData<List<QuestionsModel>>(emptyList())
    val quiz: LiveData<List<QuestionsModel>> = _quiz


    var loading = mutableStateOf(false)
    val data: MutableState<ExamDataOrException<List<QuestionsModel>, Exception>> = mutableStateOf(
        ExamDataOrException(
            listOf(),
            Exception("")
        )
    )

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            loading.value = true
            data.value = repository.getProductsFromFirestore()
            loading.value = false
        }
    }


}
