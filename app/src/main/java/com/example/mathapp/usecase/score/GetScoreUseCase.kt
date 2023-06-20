package com.example.mathapp.usecase.score

import com.example.mathapp.domain.score.external.ScoreExternalRepository
import com.example.mathapp.framework.result.model.ResultModel
import javax.inject.Inject

class GetScoreUseCase @Inject constructor(
    private val repository: ScoreExternalRepository
) {
    suspend fun invoke(): List<ResultModel> {
        return repository.getScore()
    }
}
