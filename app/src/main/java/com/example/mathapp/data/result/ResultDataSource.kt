package com.example.mathapp.data.result

import com.example.mathapp.framework.result.model.ResultModel


interface ResultDataSource {
     suspend fun insertResult(result: ResultModel )
}