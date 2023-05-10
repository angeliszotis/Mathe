package com.example.mathapp.data.exam.datasource

import com.example.mathapp.data.users.QuestionsModel
import com.example.mathapp.domain.ProductsRepository
import com.example.mathapp.ui.exam.model.ExamDataOrException
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class QuizResultsFireBase @Inject constructor(
    private val queryProductsByName: CollectionReference
) : ProductsRepository {
    override suspend fun getProductsFromFirestore(): ExamDataOrException<List<QuestionsModel>, Exception> {
        val examDataOrException = ExamDataOrException<List<QuestionsModel>, Exception>()

        try {
            examDataOrException.data = queryProductsByName.get().await().map { document ->
                document.toObject(QuestionsModel::class.java)
            }

        } catch (e: FirebaseFirestoreException) {
            examDataOrException.e = e
        }
        return examDataOrException
    }
}
/*
class QuizResultsFirebase1 @Inject constructor(
    private val collectionRef: CollectionReference
) : ProductsRepository {

    override suspend fun sendQuizResultsToFirestore(
       // quizResults: QuizResultsModel
    ): ExamDataOrException<Boolean, Exception> {

        val examDataOrException = ExamDataOrException<Boolean, Exception>()

        try {
            val docRef = collectionRef.document()
            docRef.set(quizResults).await()
            examDataOrException.data = true
        } catch (e: FirebaseFirestoreException) {
            examDataOrException.e = e
        }

        return examDataOrException
    }
}

 */