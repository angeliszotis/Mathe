package com.example.mathapp.data

import com.example.mathapp.data.exam.datasource.ProductsDatasource
import com.google.firebase.firestore.FirebaseFirestore

class ProductsProductsDatasourceImpl(
    firestore: FirebaseFirestore
) : ProductsDatasource