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
        val resultModels = mutableListOf<ResultModel>()
        val querySnapshot = firestore.collection("score").get().await()
        for (document in querySnapshot.documents) {
            val name = document.getString("name") ?: ""
            val surname = document.getString("surname") ?: ""
            val school = document.getString("school") ?: ""
            val resultModel = ResultModel(name, surname, school)
            resultModels.add(resultModel)
        }
        return resultModels
    }
}

