package com.example.mathapp.ui.exam

import androidx.lifecycle.ViewModel
import com.example.mathapp.ui.exam.composable.Question
import com.example.mathapp.ui.exam.composable.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExamViewModel @Inject constructor(
) : ViewModel() {
/*
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
        //getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            loading.value = true
            data.value = repository.getProductsFromFirestore()
            loading.value = false
        }
    }

 */

        private val questionRepository = QuestionRepository()
        private val questions = questionRepository.getQuestions()
        val randomQuestions = getRandomQuestions(questions, 12)

    private fun getRandomQuestions(questions: List<Question>, count: Int): List<Question> {
        val randomQuestions = mutableListOf<Question>()
        val usedIds = mutableSetOf<Int>()
        while (randomQuestions.size < count && usedIds.size < questions.size) {
            val question = questions.random()
            if (question.id !in usedIds && question !in randomQuestions) {
                usedIds.add(question.id)
                randomQuestions.add(question)
            }
        }
        return randomQuestions
    }

}



