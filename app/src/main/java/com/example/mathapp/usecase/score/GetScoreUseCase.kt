package com.example.mathapp.usecase.score

import com.example.mathapp.domain.score.ScoreRepository
import com.example.mathapp.framework.result.model.ResultModel
import javax.inject.Inject

class GetScoreUseCase @Inject constructor(
    private val repository: ScoreRepository
) {
    suspend fun invoke(): List<ResultModel> {
        return repository.getScore()
    }
}
