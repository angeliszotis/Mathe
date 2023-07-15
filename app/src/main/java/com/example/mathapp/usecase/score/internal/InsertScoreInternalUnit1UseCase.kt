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
import javax.inject.Inject


class InsertScoreInternalUnit1UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(result: ResultUnit1Entity) {
        repository.insertInternalScoreUnit1(result)
    }
}

class InsertScoreInternalUnit2UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(result: ResultUnit2Entity) {
        repository.insertInternalScoreUnit2(result)
    }
}

class InsertScoreInternalUnit3UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(result: ResultUnit3Entity) {
        repository.insertInternalScoreUnit3(result)
    }
}

class InsertScoreInternalUnit4UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(result: ResultUnit4Entity) {
        repository.insertInternalScoreUnit4(result)
    }
}

class InsertScoreInternalUnit5UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(result: ResultUnit5Entity) {
        repository.insertInternalScoreUnit5(result)
    }
}

class InsertScoreInternalUnit6UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(result: ResultUnit6Entity) {
        repository.insertInternalScoreUnit6(result)
    }
}

class InsertScoreInternalUnit7UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(result: ResultUnit7Entity) {
        repository.insertInternalScoreUnit7(result)
    }
}

class InsertScoreInternalUnit8UseCase @Inject constructor(
    private val repository: ScoreInternalRepository
) {
    suspend fun invoke(result: ResultUnit8Entity) {
        repository.insertInternalScoreUnit8(result)
    }
}