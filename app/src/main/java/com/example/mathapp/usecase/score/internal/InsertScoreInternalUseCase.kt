package com.example.mathapp.usecase.score.internal

import com.example.mathapp.domain.score.internal.ScoreInternalRepository
import com.example.mathapp.framework.result.model.ResultEntity
import javax.inject.Inject


class InsertScoreInternalUseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(Result: ResultEntity){
        repository.insertUsers(Result)
    }
}