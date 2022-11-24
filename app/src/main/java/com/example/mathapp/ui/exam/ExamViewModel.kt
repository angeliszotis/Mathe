package com.example.mathapp.ui.exam

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.mathapp.domain.Resource
import com.example.mathapp.data.model.QuestionsModel
import com.example.mathapp.data.nav_data.NavButtonItems
import com.example.mathapp.domain.QuizRepository
import com.example.mathapp.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ExamViewModel @Inject constructor(
    private val quizRepository: QuizRepository
) : ViewModel() {

    private val _ldata = SingleLiveEvent<NavDirections>()
    val ldata: LiveData<NavDirections> = _ldata

    private var _quiz = MutableLiveData<List<QuestionsModel>>(emptyList())
    val quiz: LiveData<List<QuestionsModel>> = _quiz


    fun onDataTake() {
        quizRepository.getQuizOnce()
            .onEach { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _quiz.value = resource.data!!
                    }
                    is Resource.Error -> {
                        Log.w("test", resource.error!!)
                    }
                }
            }
    }


    fun onItemClicked(item: NavButtonItems) {
        _ldata.value = item.destination
    }


}
