package com.example.mathapp.framework.theory.model

import com.example.mathapp.util.NavExamItems
import com.example.mathapp.util.NavScoreItems


data class UnitTheoryModel(val url: String, val nameResourceId: Int)
data class UnitExamModel( val action: NavExamItems, val nameResourceId: Int)
data class UnitScoreModel( val action: NavScoreItems, val nameResourceId: Int)
