package com.example.mathapp.domain

import com.example.mathapp.data.model.DataOrException
import com.example.mathapp.data.model.QuestionsModel

/*
interface QuizRepository {
    fun getQuizOnce(): Flow<Resource<List<QuestionsModel>>>
    fun getQuizRealtime(): Flow<Resource<List<QuestionsModel>>>
}
*/
interface ProductsRepository {
    suspend fun getProductsFromFirestore(): DataOrException<List<QuestionsModel>, Exception>
}
