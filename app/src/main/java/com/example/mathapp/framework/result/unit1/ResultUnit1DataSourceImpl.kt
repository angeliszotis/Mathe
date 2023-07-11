package com.example.mathapp.framework.result.unit1

import android.util.Log
import com.example.mathapp.data.result.unit1.ResultUnit1DataSource
import com.example.mathapp.framework.result.model.ResultModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ResultUnit1DataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : ResultUnit1DataSource {

    override suspend fun insertResult(result: ResultModel) {

        firestore.collection("score").add(result).addOnSuccessListener { documentReference ->
            Log.d("Yoda", "Document inserted with ID: ${documentReference.id}")
        }
            .addOnFailureListener { e ->
                Log.w("Yoda", "Error inserting document", e)
            }
            .await()
    }
}

