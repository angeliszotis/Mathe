package com.example.mathapp.usecase.score.internal

import com.example.mathapp.domain.score.internal.ScoreInternalRepository
import com.example.mathapp.framework.result.model.ResultUnit1Entity
import com.example.mathapp.framework.result.model.ResultUnit2Entity
import com.example.mathapp.framework.result.model.ResultUnit3Entity
import com.example.mathapp.framework.result.model.ResultUnit4Entity
import com.example.mathapp.framework.result.model.ResultUnit5Entity
import com.example.mathapp.framework.result.model.ResultUnit6Entity
import com.example.mathapp.framework.result.model.ResultUnit7Entity
import com.example.mathapp.framework.result.model.ResultUnit8Entity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetScoreInternalUnit1UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(): Flow<List<ResultUnit1Entity>> {
        return repository.getScoreUnit1()
    }
}

class GetScoreInternalUnit2UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(): Flow<List<ResultUnit2Entity>> {
        return repository.getScoreUnit2()
    }
}

class GetScoreInternalUnit3UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(): Flow<List<ResultUnit3Entity>> {
        return repository.getScoreUnit3()
    }
}

class GetScoreInternalUnit4UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(): Flow<List<ResultUnit4Entity>> {
        return repository.getScoreUnit4()
    }
}

class GetScoreInternalUnit5UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(): Flow<List<ResultUnit5Entity>> {
        return repository.getScoreUnit5()
    }
}

class GetScoreInternalUnit6UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(): Flow<List<ResultUnit6Entity>> {
        return repository.getScoreUnit6()
    }
}

class GetScoreInternalUnit7UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(): Flow<List<ResultUnit7Entity>> {
        return repository.getScoreUnit7()
    }
}

class GetScoreInternalUnit8UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(): Flow<List<ResultUnit8Entity>> {
        return repository.getScoreUnit8()
    }
}
