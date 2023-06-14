package com.example.mathapp.framework.result

import android.util.Log
import com.example.mathapp.data.result.ResultDataSource
import com.example.mathapp.framework.result.model.ResultModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ResultDataSourceImpl @Inject constructor(
private val firestore : FirebaseFirestore
) : ResultDataSource {

    override suspend fun insertResult(result: ResultModel) {
        /*
        val resultDocument = firestore
                .collection("score")
                .document()
            resultDocument.set(result)

         */

        firestore.collection("score").add(result).addOnSuccessListener { documentReference ->
                Log.d("Yoda", "Document inserted with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("Yoda", "Error inserting document", e)
            }
            .await()
    }
}

