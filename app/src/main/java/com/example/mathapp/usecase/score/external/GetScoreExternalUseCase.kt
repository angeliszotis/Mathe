package com.example.mathapp.usecase.score.external

import com.example.mathapp.domain.score.external.ScoreExternalRepository
import com.example.mathapp.framework.result.model.ResultModel
import javax.inject.Inject

class GetScoreExternalUseCase @Inject constructor(
    private val repository: ScoreExternalRepository
) {
    suspend fun invoke(unit:Int): List<ResultModel> {
        return repository.getScore(unit = unit)
    }
}
