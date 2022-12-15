package com.example.mathapp.data.exam

import com.example.mathapp.data.model.DataOrException
import com.example.mathapp.data.model.QuestionsModel
import com.example.mathapp.domain.ProductsRepository
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.Query
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val queryProductsByName: CollectionReference
) : ProductsRepository {
    override suspend fun getProductsFromFirestore(): DataOrException<List<QuestionsModel>, Exception> {
        val dataOrException = DataOrException<List<QuestionsModel>, Exception>()


        try {

            dataOrException.data = queryProductsByName.get().await().map { document ->
                document.toObject(QuestionsModel::class.java)


            }

        } catch (e: FirebaseFirestoreException) {
            dataOrException.e = e
        }
        return dataOrException
    }
}