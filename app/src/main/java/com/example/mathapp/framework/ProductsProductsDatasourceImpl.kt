package com.example.mathapp.framework

import com.example.mathapp.data.ProductsDatasource
import com.google.firebase.firestore.FirebaseFirestore

class ProductsProductsDatasourceImpl(
    firestore: FirebaseFirestore
) : ProductsDatasource