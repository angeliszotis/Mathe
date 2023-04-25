package com.example.mathapp.framework.exam

import com.example.mathapp.ui.exam.model.ExamDataOrException
import com.example.mathapp.data.users.QuestionsModel
import com.example.mathapp.domain.ProductsRepository
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
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