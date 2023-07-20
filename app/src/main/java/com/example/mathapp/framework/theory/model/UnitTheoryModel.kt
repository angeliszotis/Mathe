package com.example.mathapp.framework.theory.model

import androidx.navigation.NavDirections
import com.example.mathapp.util.NavExamItems


data class UnitTheoryModel(val url: String, val nameResourceId: Int)
data class UnitExamModel( val action: NavExamItems?, val nameResourceId: Int?)
data class UnitScoreInternalModel(val action: NavDirections, val nameResourceId: Int)
