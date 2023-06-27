package com.example.mathapp.usecase.score.internal

import com.example.mathapp.domain.score.internal.ScoreInternalRepository
import com.example.mathapp.framework.result.model.ResultEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetScoreInternalUseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(): Flow<List<ResultEntity>> {
        return repository.getScore()
    }
}
