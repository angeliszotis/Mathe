package com.example.mathapp.domain.Quiz

import android.content.ContentValues
import android.util.Log
import com.example.mathapp.domain.Resource
import com.example.mathapp.data.model.QuestionsModel
import com.example.mathapp.domain.QuizRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow


class QuizRepositoryImpl(
    private val database: FirebaseDatabase
) : QuizRepository {


    override fun getQuizOnce(): Flow<Resource<List<QuestionsModel>>> = callbackFlow {
        Log.i("lala", "Got value OK")

        database.getReference("quiz").child("unit1")
            .get()
            .addOnCompleteListener { task ->
                val response = if (task.isSuccessful) {
                    val quiz = task.result.getValue<List<QuestionsModel>>()!!
                    Resource.Success<List<QuestionsModel>>(quiz)
                } else {
                    Log.w("lala","No")
                    Resource.Error<List<QuestionsModel>>(task.exception?.localizedMessage.toString())

                }
                trySend(response).isSuccess
            }

        awaitClose {
            close()
        }
    }

    override fun getQuizRealtime(): Flow<Resource<List<QuestionsModel>>> = callbackFlow {
        database.getReference("cars")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val quiz = dataSnapshot.getValue<List<QuestionsModel>>()!!
                    trySend(Resource.Success<List<QuestionsModel>>(quiz)).isSuccess
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.w("cars", "Failed to read value.")
                    trySend(Resource.Error<List<QuestionsModel>>(error = error.message)).isFailure
                }
            })

        awaitClose {
            close()
        }
    }

}

