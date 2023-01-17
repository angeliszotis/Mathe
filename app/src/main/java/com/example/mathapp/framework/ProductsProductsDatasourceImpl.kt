package com.example.mathapp.framework

import com.example.mathapp.framework.exam.datasource.ProductsDatasource
import com.google.firebase.firestore.FirebaseFirestore

class ProductsProductsDatasourceImpl(
    firestore: FirebaseFirestore
) : ProductsDatasource