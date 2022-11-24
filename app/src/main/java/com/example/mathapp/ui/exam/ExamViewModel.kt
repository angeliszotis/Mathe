package com.example.mathapp.ui.exam

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.mathapp.data.model.QuestionsModel
import com.example.mathapp.data.nav_data.NavButtonItems
import com.example.mathapp.domain.QuizRepository
import com.example.mathapp.domain.Resource
import com.example.mathapp.util.SingleLiveEvent
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ExamViewModel @Inject constructor(
    private val db : FirebaseDatabase,
    private val quizRepository: QuizRepository
) : ViewModel() {

    private val _ldata = SingleLiveEvent<NavDirections>()
    val ldata: LiveData<NavDirections> = _ldata

    private var _quiz = MutableLiveData<List<QuestionsModel>>(emptyList())
    val quiz: LiveData<List<QuestionsModel>> = _quiz

    val myRef = db.getReference("quiz").child("unit1").child("q1")

    var test : String = ""



    fun getMydata():String{
        var test : String = "13"
        myRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                // val value = dataSnapshot.getValue<String>()
                val map = dataSnapshot.value as Map<String, Any>?
                Log.d("yoda", "Value is: ${map?.getValue("answer")}")
                test = map?.getValue("answer").toString()
                //test= map?.getValue("answer").toString()

            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })

        return test
    }

    fun onDataTake() {
        quizRepository.getQuizOnce()
            .onEach { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _quiz.value = resource.data!!
                    }
                    is Resource.Error -> {
                        Log.w("test", resource.error!!)
                    }
                }
            }
    }


    fun onItemClicked(item: NavButtonItems) {
        _ldata.value = item.destination
    }


}
