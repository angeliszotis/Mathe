package com.example.mathapp.ui.exam

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.example.mathapp.data.ProductsRepositoryImpl
import com.example.mathapp.data.model.DataOrException
import com.example.mathapp.data.model.QuestionsModel
import com.example.mathapp.data.nav_data.NavButtonItems
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
    val data: MutableState<DataOrException<List<QuestionsModel>, Exception>> = mutableStateOf(
        DataOrException(
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


/*
    fun getMydata(): QuestionsModel {

        myRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val map = dataSnapshot.value.toString()?:""
                //Log.d("yoda", "Value is: ${map?.getVal"answer")}")
                test = map
                //test= map?.getValue("answer").toString()

            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })

        return test
    } */
/*
    fun onDataTake() {
        quizRepository.getQuizOnce()
            .onEach { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _quiz.value = resource.data!!
                        Log.e("yoda2","ok")
                    }
                    is Resource.Error -> {
                        Log.w("test", resource.error!!)
                        Log.e("yoda2","ok")

                    }
                }
            }

    }*/

    fun onItemClicked(item: NavButtonItems) {
        _ldata.value = item.destination
    }


}
