package com.example.mathapp.framework.score.external

import com.example.mathapp.data.score.external.ScoreExternalDataSource
import com.example.mathapp.framework.result.model.ResultModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class ScoreExternalDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : ScoreExternalDataSource {

    override suspend fun getScore(unit:Int): List<ResultModel> {
        val userModels = mutableListOf<ResultModel>()
        val collectionName = "score$unit"
        val querySnapshot = firestore.collection(collectionName).get().await()
        for (document in querySnapshot.documents) {
            val name = document.getString("name") ?: ""
            val surname = document.getString("surname") ?: ""
            val school = document.getString("school") ?: ""
            val correct = document.getString("correct") ?: ""
            val incorrect = document.getString("incorrect") ?: ""
            val time = document.getString("time") ?: ""
            val userModel = ResultModel(name = name,surname = surname,school = school,correct = correct,incorrect = incorrect,time = time)
            userModels.add(userModel)
        }
        return userModels
    }
}

