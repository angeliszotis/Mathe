package com.example.mathapp.ui.exam.map

import com.example.mathapp.framework.result.model.ResultAnswerModel
import com.example.mathapp.framework.result.model.ResultModel
import com.example.mathapp.framework.result.model.ResultUnit1Entity
import com.example.mathapp.framework.result.model.ResultUnit2Entity
import com.example.mathapp.framework.result.model.ResultUnit3Entity
import com.example.mathapp.framework.result.model.ResultUnit4Entity
import com.example.mathapp.framework.result.model.ResultUnit5Entity
import com.example.mathapp.framework.result.model.ResultUnit6Entity
import com.example.mathapp.framework.result.model.ResultUnit7Entity
import com.example.mathapp.framework.result.model.ResultUnit8Entity
import com.example.mathapp.framework.users.model.UserEntity

 fun userMap(userEntity: UserEntity, result: ResultAnswerModel): ResultModel {
    return ResultModel(
        name = userEntity.name,
        surname = userEntity.surname,
        school = userEntity.school,
        correct = result.corect.toString(),
        incorrect = result.incorect.toString(),
        time = result.time.toString(),
        point = result.point.toString()
    )
}
fun mapToResultModelUnit(resultEntity: ResultUnit1Entity): ResultModel {
    return ResultModel(
        name = resultEntity.name ?: "",
        surname = resultEntity.surname ?: "",
        school = resultEntity.school ?: "",
        correct = resultEntity.correct ?: "",
        incorrect = resultEntity.incorrect ?: "",
        time = resultEntity.time ?: "",
        point = resultEntity.point ?:""
    )
}
fun mapToResultModelUnit(resultEntity: ResultUnit2Entity): ResultModel {
    return ResultModel(
        name = resultEntity.name ,
        surname = resultEntity.surname ,
        school = resultEntity.school ,
        correct = resultEntity.correct ,
        incorrect = resultEntity.incorrect ,
        time = resultEntity.time,
        point = resultEntity.point ?: ""
    )

}
fun mapToResultModelUnit(resultEntity: ResultUnit3Entity): ResultModel {
    return ResultModel(
        name = resultEntity.name ,
        surname = resultEntity.surname ,
        school = resultEntity.school ,
        correct = resultEntity.correct ,
        incorrect = resultEntity.incorrect ,
        time = resultEntity.time,
        point = resultEntity.point ?: ""
    )
}

fun mapToResultModelUnit(resultEntity: ResultUnit4Entity): ResultModel {
    return ResultModel(
        name = resultEntity.name ,
        surname = resultEntity.surname ,
        school = resultEntity.school ,
        correct = resultEntity.correct ,
        incorrect = resultEntity.incorrect ,
        time = resultEntity.time,
        point = resultEntity.point ?: ""
    )
}

fun mapToResultModelUnit(resultEntity: ResultUnit5Entity): ResultModel {
    return ResultModel(
        name = resultEntity.name ,
        surname = resultEntity.surname ,
        school = resultEntity.school ,
        correct = resultEntity.correct ,
        incorrect = resultEntity.incorrect ,
        time = resultEntity.time,
        point = resultEntity.point ?: ""
    )
}

fun mapToResultModelUnit(resultEntity: ResultUnit6Entity): ResultModel {
    return ResultModel(
        name = resultEntity.name ,
        surname = resultEntity.surname ,
        school = resultEntity.school ,
        correct = resultEntity.correct ,
        incorrect = resultEntity.incorrect ,
        time = resultEntity.time,
        point = resultEntity.point ?: ""
    )
}

fun mapToResultModelUnit(resultEntity: ResultUnit7Entity): ResultModel {
    return ResultModel(
        name = resultEntity.name ,
        surname = resultEntity.surname ,
        school = resultEntity.school ,
        correct = resultEntity.correct ,
        incorrect = resultEntity.incorrect ,
        time = resultEntity.time,
        point = resultEntity.point ?: ""
    )
}

fun mapToResultModelUnit(resultEntity: ResultUnit8Entity): ResultModel {
    return ResultModel(
        name = resultEntity.name ,
        surname = resultEntity.surname ,
        school = resultEntity.school ,
        correct = resultEntity.correct ,
        incorrect = resultEntity.incorrect ,
        time = resultEntity.time,
        point = resultEntity.point ?: ""
    )
}

fun scoreInternalMapUnit(userEntity: UserEntity, result: ResultAnswerModel): ResultUnit1Entity {
    return ResultUnit1Entity(
        name = userEntity.name,
        surname = userEntity.surname,
        school = userEntity.school,
        correct = result.corect.toString(),
        incorrect = result.incorect.toString(),
        time = result.time.toString(),
        point = result.point
    )
}

fun scoreInternalMapUnit2(userEntity: UserEntity, result: ResultAnswerModel): ResultUnit2Entity {
    return ResultUnit2Entity(
        name = userEntity.name,
        surname = userEntity.surname,
        school = userEntity.school,
        correct = result.corect.toString(),
        incorrect = result.incorect.toString(),
        time = result.time.toString(),
        point = result.point
    )
}

fun scoreInternalMapUnit3(userEntity: UserEntity, result: ResultAnswerModel): ResultUnit3Entity {
    return ResultUnit3Entity(
        name = userEntity.name,
        surname = userEntity.surname,
        school = userEntity.school,
        correct = result.corect.toString(),
        incorrect = result.incorect.toString(),
        time = result.time.toString(),
        point = result.point
    )
}

fun scoreInternalMapUnit4(userEntity: UserEntity, result: ResultAnswerModel): ResultUnit4Entity {
    return ResultUnit4Entity(
        name = userEntity.name,
        surname = userEntity.surname,
        school = userEntity.school,
        correct = result.corect.toString(),
        incorrect = result.incorect.toString(),
        time = result.time.toString()
    )
}

fun scoreInternalMapUnit5(userEntity: UserEntity, result: ResultAnswerModel): ResultUnit5Entity {
    return ResultUnit5Entity(
        name = userEntity.name,
        surname = userEntity.surname,
        school = userEntity.school,
        correct = result.corect.toString(),
        incorrect = result.incorect.toString(),
        time = result.time.toString(),
        point = result.point
    )
}

fun scoreInternalMapUnit6(userEntity: UserEntity, result: ResultAnswerModel): ResultUnit6Entity {
    return ResultUnit6Entity(
        name = userEntity.name,
        surname = userEntity.surname,
        school = userEntity.school,
        correct = result.corect.toString(),
        incorrect = result.incorect.toString(),
        time = result.time.toString(),
        point = result.point
    )
}

fun scoreInternalMapUnit7(userEntity: UserEntity, result: ResultAnswerModel): ResultUnit7Entity {
    return ResultUnit7Entity(
        name = userEntity.name,
        surname = userEntity.surname,
        school = userEntity.school,
        correct = result.corect.toString(),
        incorrect = result.incorect.toString(),
        time = result.time.toString(),
        point = result.point
    )
}

fun scoreInternalMapUnit8(userEntity: UserEntity, result: ResultAnswerModel): ResultUnit8Entity {
    return ResultUnit8Entity(
        name = userEntity.name,
        surname = userEntity.surname,
        school = userEntity.school,
        correct = result.corect.toString(),
        incorrect = result.incorect.toString(),
        time = result.time.toString(),
        point = result.point
    )
}
