package com.example.mathapp.util

import com.example.mathapp.R
import com.example.mathapp.framework.theory.model.UnitExamModel
import com.example.mathapp.framework.theory.model.UnitScoreModel
import com.example.mathapp.framework.theory.model.UnitTheoryModel

const val BASE_URL_LOTTIE_PROFILE_lf20_START = "https://assets10.lottiefiles.com/packages/lf20_n1wgeaxb.json"
const val BASE_URL_LOTTIE_PROFILE_lf20_END = "https://assets10.lottiefiles.com/packages/lf20_xyadoh9h.json"

const val BASE_URL_LOTTIE_THEORY_lf20_START = "https://assets6.lottiefiles.com/packages/lf20_zunhpwue.json"

const val BASE_URL_LOTTIE_DASHBOARD_lf20_END = "https://assets5.lottiefiles.com/packages/lf20_YrdJ2K8cQY.json"

const val BASE_URL_LOTTIE_SCORE_lf20_START = "https://assets4.lottiefiles.com/packages/lf20_bq0iyadj.json"
const val BASE_URL_LOTTIE_SCORE_lf20_END = "https://assets3.lottiefiles.com/packages/lf20_si7bhkv8.json"

const val BASE_URL_LOTTIE_RESULTS_lf20_END = "https://assets4.lottiefiles.com/packages/lf20_kfl4ksd9.json"

val units = listOf(
    UnitTheoryModel(
        url = "http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-1_1.html",
        nameResourceId = R.string.unit_one
    ),
    UnitTheoryModel(
        url = "http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-2_8.html",
        nameResourceId = R.string.unit_two
    ),
    UnitTheoryModel(
        url = "http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-3_13.html",
        nameResourceId = R.string.unit_three
    ),
    UnitTheoryModel(
        url = "http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-4_22.html",
        nameResourceId = R.string.unit_four
    ),
    UnitTheoryModel(
        url = "http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-5_25.html",
        nameResourceId = R.string.unit_five
    ),
    UnitTheoryModel(
        url = "http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-6_33.html",
        nameResourceId = R.string.unit_six
    ),
    UnitTheoryModel(
        url = "http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-7_36.html",
        nameResourceId = R.string.unit_seven
    ),
    UnitTheoryModel(
        url = "http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-8_45.html",
        nameResourceId = R.string.unit_eight
    )
)
val unitsExam = listOf(
    UnitExamModel(
        action = NavExamItems.UnitOne,
        nameResourceId = R.string.unit_one
    ),
    UnitExamModel(
        action = NavExamItems.UnitOne,
        nameResourceId = R.string.unit_two
    ),
    UnitExamModel(
        action = NavExamItems.UnitOne,
        nameResourceId = R.string.unit_three
    ),
    UnitExamModel(
        action = NavExamItems.UnitOne,
        nameResourceId = R.string.unit_four
    ),
    UnitExamModel(
        action = NavExamItems.UnitOne,
        nameResourceId = R.string.unit_five
    ),
    UnitExamModel(
        action = NavExamItems.UnitOne,
        nameResourceId = R.string.unit_six
    ),
    UnitExamModel(
        action = NavExamItems.UnitOne,
        nameResourceId = R.string.unit_seven
    ),
    UnitExamModel(
        action = NavExamItems.UnitOne,
        nameResourceId = R.string.unit_eight
    )
)
val unitsScore = listOf(
    UnitScoreModel(
        action = NavScoreItems.ScoreInternal,
        nameResourceId = R.string.unit_one
    ),
    UnitScoreModel(
        action = NavScoreItems.ScoreInternal,
        nameResourceId = R.string.unit_one
    ), UnitScoreModel(
        action = NavScoreItems.ScoreInternal,
        nameResourceId = R.string.unit_one
    ), UnitScoreModel(
        action = NavScoreItems.ScoreInternal,
        nameResourceId = R.string.unit_one
    ), UnitScoreModel(
        action = NavScoreItems.ScoreInternal,
        nameResourceId = R.string.unit_one
    ), UnitScoreModel(
        action = NavScoreItems.ScoreInternal,
        nameResourceId = R.string.unit_one
    ), UnitScoreModel(
        action = NavScoreItems.ScoreInternal,
        nameResourceId = R.string.unit_one
    ), UnitScoreModel(
        action = NavScoreItems.ScoreInternal,
        nameResourceId = R.string.unit_one
    )

)