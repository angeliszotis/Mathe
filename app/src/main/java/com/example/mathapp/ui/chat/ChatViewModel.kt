package com.example.mathapp.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathapp.framework.users.model.UserEntity
import com.example.mathapp.ui.chat.composable.ChatMessage
import com.example.mathapp.usecase.user.GetUsersUseCase
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {
    private val database = FirebaseDatabase.getInstance().reference.child("messages")
    private val _messageList = MutableLiveData<List<ChatMessage>>()
    val messageList: LiveData<List<ChatMessage>> get() = _messageList

    private val _getUserData = MutableLiveData<List<UserEntity>>()
    val getUserData: LiveData<List<UserEntity>> = _getUserData

    init {
        getUser()
        // Set up Firebase Realtime Database Listener for new messages
        database.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val chatMessage = snapshot.getValue(ChatMessage::class.java)
                chatMessage?.let {
                    val updatedList = _messageList.value?.toMutableList() ?: mutableListOf()
                    updatedList.add(it)
                    _messageList.value = updatedList
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onChildRemoved(snapshot: DataSnapshot) {}
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {}
        })
    }

    fun sendMessage(messageText: String) {

        //val user = FirebaseAuth.getInstance().currentUser
        //val userId = user?.uid ?: ""
        val userName =  _getUserData.value?.lastOrNull()?.surname ?: "Anonymous"//user?.displayName ?: "Anonymous"

        val chatMessage = ChatMessage("userId", userName, messageText)
        database.push().setValue(chatMessage)
    }

    private fun getUser() {
        viewModelScope.launch(Dispatchers.IO) {
            getUsersUseCase.invoke().collect { users ->
                _getUserData.postValue(users)
            }
        }
    }
}
