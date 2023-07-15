package com.example.mathapp.framework.result

import android.util.Log
import com.example.mathapp.data.result.ResultDataSource
import com.example.mathapp.framework.result.model.ResultModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ResultDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : ResultDataSource {

    override suspend fun insertResultUnit1(result: ResultModel) {

        firestore.collection("score1").add(result).addOnSuccessListener { documentReference ->
            Log.d("Yoda", "Document inserted with ID: ${documentReference.id}")
        }.addOnFailureListener { e -> Log.w("Yoda", "Error inserting document", e) }.await()
    }

    override suspend fun insertResultUnit2(result: ResultModel) {
        firestore.collection("score2").add(result).addOnSuccessListener { documentReference ->
            Log.d("Yoda", "Document inserted with ID: ${documentReference.id}")
        }.addOnFailureListener { e -> Log.w("Yoda", "Error inserting document", e) }.await()
    }

    override suspend fun insertResultUnit3(result: ResultModel) {
        firestore.collection("score3").add(result).addOnSuccessListener { documentReference ->
            Log.d("Yoda", "Document inserted with ID: ${documentReference.id}")
        }.addOnFailureListener { e -> Log.w("Yoda", "Error inserting document", e) }.await()
    }

    override suspend fun insertResultUnit4(result: ResultModel) {
        firestore.collection("score4").add(result).addOnSuccessListener { documentReference ->
            Log.d("Yoda", "Document inserted with ID: ${documentReference.id}")
        }.addOnFailureListener { e -> Log.w("Yoda", "Error inserting document", e) }.await()
    }

    override suspend fun insertResultUnit5(result: ResultModel) {
        firestore.collection("score5").add(result).addOnSuccessListener { documentReference ->
            Log.d("Yoda", "Document inserted with ID: ${documentReference.id}")
        }.addOnFailureListener { e -> Log.w("Yoda", "Error inserting document", e) }.await()
    }

    override suspend fun insertResultUnit6(result: ResultModel) {
        firestore.collection("score6").add(result).addOnSuccessListener { documentReference ->
            Log.d("Yoda", "Document inserted with ID: ${documentReference.id}")
        }.addOnFailureListener { e -> Log.w("Yoda", "Error inserting document", e) }.await()
    }

    override suspend fun insertResultUnit7(result: ResultModel) {
        firestore.collection("score7").add(result).addOnSuccessListener { documentReference ->
            Log.d("Yoda", "Document inserted with ID: ${documentReference.id}")
        }.addOnFailureListener { e -> Log.w("Yoda", "Error inserting document", e) }.await()
    }

    override suspend fun insertResultUnit8(result: ResultModel) {
        firestore.collection("score8").add(result).addOnSuccessListener { documentReference ->
            Log.d("Yoda", "Document inserted with ID: ${documentReference.id}")
        }.addOnFailureListener { e -> Log.w("Yoda", "Error inserting document", e) }.await()
    }
}

