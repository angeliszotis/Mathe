package com.example.mathapp.ui.score.achievement.map

import com.example.mathapp.framework.result.model.AchievementPointModel
import com.example.mathapp.framework.result.model.ResultModel

fun AchievementMap(result:ResultModel,unit:Int): AchievementPointModel {
    return  AchievementPointModel(
        unit = unit,
        point = result.point.toInt()
    )
}

