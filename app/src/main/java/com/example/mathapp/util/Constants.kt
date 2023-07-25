package com.example.mathapp.util

import com.example.mathapp.R
import com.example.mathapp.framework.theory.model.UnitExamModel
import com.example.mathapp.framework.theory.model.UnitScoreInternalModel
import com.example.mathapp.framework.theory.model.UnitTheoryModel

const val BASE_URL_LOTTIE_PROFILE_lf20_START = "https://assets10.lottiefiles.com/packages/lf20_n1wgeaxb.json"
const val BASE_URL_LOTTIE_PROFILE_lf20_END = "https://assets10.lottiefiles.com/packages/lf20_xyadoh9h.json"

const val BASE_URL_LOTTIE_THEORY_lf20_START = "https://assets6.lottiefiles.com/packages/lf20_zunhpwue.json"

const val BASE_URL_LOTTIE_DASHBOARD_lf20_END = "https://assets5.lottiefiles.com/packages/lf20_YrdJ2K8cQY.json"

const val BASE_URL_LOTTIE_SCORE_lf20_START = "https://assets4.lottiefiles.com/packages/lf20_bq0iyadj.json"
const val BASE_URL_LOTTIE_SCORE_lf20_MIDDLE = "https://assets3.lottiefiles.com/packages/lf20_si7bhkv8.json"
const val BASE_URL_LOTTIE_SCORE_lf20_END = "https://lottie.host/639f30b8-9c55-4d62-a58b-4d8ff04a3f67/68mQzVlupR.json"

const val BASE_URL_LOTTIE_RESULTS_lf20_END = "https://assets4.lottiefiles.com/packages/lf20_kfl4ksd9.json"
const val BASE_URL_LOTTIE_RESULTS_lf20_END2 = "https://lottie.host/b31d7aec-4ced-427e-a0fb-7fb0fc7ee261/VVn1fQDkx2.json"
const val BASE_URL_LOTTIE_RESULTS_lf20_END3 = "https://lottie.host/ddcd01b8-2e74-4c62-a7d9-b034b47f2541/BxyvMXAU54.json"

const val BASE_URL_LOTTIE_QUIZ_lf20_END1 = "https://lottie.host/805cd4ea-b2af-4013-91e2-1cc3e47aed91/CUYAoIHUQp.json"
const val BASE_URL_LOTTIE_QUIZ_lf20_END2 = "https://lottie.host/d4cf573f-51e3-484d-a472-1441d603613d/93xZQAegAM.json"
const val BASE_URL_LOTTIE_QUIZ_lf20_END3 = "https://lottie.host/8888e0b7-46be-4b4d-9a0b-6f4553519aff/RenM8s0p22.json"

const val BASE_URL_LOTTIE_CHAT_lf20_END = "https://lottie.host/1fe5dc82-59cb-4444-a2a1-952c46ab20d1/UWz6m6EQfm.json"


val units = listOf(
    UnitTheoryModel(url="http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-1_1.html", nameResourceId=R.string.unit_one),
    UnitTheoryModel(url="http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-2_8.html", nameResourceId=R.string.unit_two),
    UnitTheoryModel(url="http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-3_13.html", nameResourceId=R.string.unit_three),
    UnitTheoryModel(url="http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-4_22.html", nameResourceId=R.string.unit_four),
    UnitTheoryModel(url="http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-5_25.html", nameResourceId=R.string.unit_five),
    UnitTheoryModel(url="http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-6_33.html", nameResourceId=R.string.unit_six),
    UnitTheoryModel(url="http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-7_36.html", nameResourceId=R.string.unit_seven),
    UnitTheoryModel(url="http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-8_45.html", nameResourceId=R.string.unit_eight)
)
val unitsExam = listOf(
    UnitExamModel(action = NavExamItems.UnitOne, nameResourceId = R.string.unit_one),
    UnitExamModel(action = NavExamItems.UnitTwo, nameResourceId = R.string.unit_two),
    UnitExamModel(action = NavExamItems.UnitThree, nameResourceId = R.string.unit_three),
    UnitExamModel(action = NavExamItems.UnitFour, nameResourceId = R.string.unit_four),
    UnitExamModel(action = NavExamItems.UnitFive, nameResourceId = R.string.unit_five),
    UnitExamModel(action = NavExamItems.UnitSix, nameResourceId = R.string.unit_six),
    UnitExamModel(action = NavExamItems.UnitSeven, nameResourceId = R.string.unit_seven),
    UnitExamModel(action = NavExamItems.UnitEight, nameResourceId = R.string.unit_eight)
)
val unitsInternalScore = listOf(
    UnitScoreInternalModel(action = NavScoreInternal.UnitOne.destination, nameResourceId = R.string.unit_one),
    UnitScoreInternalModel(action = NavScoreInternal.UnitTwo.destination, nameResourceId = R.string.unit_two),
    UnitScoreInternalModel(action = NavScoreInternal.UnitThree.destination, nameResourceId = R.string.unit_three),
    UnitScoreInternalModel(action = NavScoreInternal.UnitFour.destination, nameResourceId = R.string.unit_four),
    UnitScoreInternalModel(action = NavScoreInternal.UnitFive.destination, nameResourceId = R.string.unit_five),
    UnitScoreInternalModel(action = NavScoreInternal.UnitSix.destination, nameResourceId = R.string.unit_six),
    UnitScoreInternalModel(action = NavScoreInternal.UnitSeven.destination, nameResourceId = R.string.unit_seven),
    UnitScoreInternalModel(action = NavScoreInternal.UnitEight.destination, nameResourceId = R.string.unit_eight)
)
val unitsExternalScore = listOf(
    UnitScoreInternalModel(action = NavScoreExternal.UnitOne.destination, nameResourceId = R.string.unit_one),
    UnitScoreInternalModel(action = NavScoreExternal.UnitTwo.destination, nameResourceId = R.string.unit_two),
    UnitScoreInternalModel(action = NavScoreExternal.UnitThree.destination, nameResourceId = R.string.unit_three),
    UnitScoreInternalModel(action = NavScoreExternal.UnitFour.destination, nameResourceId = R.string.unit_four),
    UnitScoreInternalModel(action = NavScoreExternal.UnitFive.destination, nameResourceId = R.string.unit_five),
    UnitScoreInternalModel(action = NavScoreExternal.UnitSix.destination, nameResourceId = R.string.unit_six),
    UnitScoreInternalModel(action = NavScoreExternal.UnitSeven.destination, nameResourceId = R.string.unit_seven),
    UnitScoreInternalModel(action = NavScoreExternal.UnitEight.destination, nameResourceId = R.string.unit_eight)
)