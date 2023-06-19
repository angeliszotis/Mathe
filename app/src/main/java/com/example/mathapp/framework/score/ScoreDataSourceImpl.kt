package com.example.mathapp.framework.score

import com.example.mathapp.data.score.ScoreDataSource
import com.example.mathapp.framework.result.model.ResultModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class ScoreDataSourceImpl @Inject constructor(
    private val firestore : FirebaseFirestore
) : ScoreDataSource {

    override suspend fun getScore(): List<ResultModel> {
        val userModels = mutableListOf<ResultModel>()
        val querySnapshot = firestore.collection("score").get().await()
        for (document in querySnapshot.documents) {
            val name = document.getString("name") ?: ""
            val surname = document.getString("surname") ?: ""
            val school = document.getString("school") ?: ""
            val correct = document.getString("corect")?: ""
            val incorrect = document.getString("incorect")?: ""
            val time = document.getString("time")?: ""
            val userModel =  ResultModel(name, surname, school, correct = correct , incorrect = incorrect , time = time)
            userModels.add(userModel)
        }
        return userModels
    }
}

