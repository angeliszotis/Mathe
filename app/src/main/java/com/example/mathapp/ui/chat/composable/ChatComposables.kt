package com.example.mathapp.ui.chat.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathapp.ui.chat.ChatViewModel
import com.example.mathapp.ui.composable.LottieLoader.LottieLoader
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.FbColor
import com.example.mathapp.ui.theme.SpacingCustom_10dp
import com.example.mathapp.ui.theme.SpacingCustom_6dp
import com.example.mathapp.ui.theme.SpacingHalf_8dp
import com.example.mathapp.util.BASE_URL_LOTTIE_CHAT_lf20_END

@Composable
fun ChatScreen(viewModel: ChatViewModel) {
    val messageList by viewModel.messageList.observeAsState(emptyList())
    val mySurname by viewModel.getUserData.observeAsState(emptyList())
    var messageText by remember { mutableStateOf("") }


    Column(modifier = Modifier
        .fillMaxSize()
        .background(BabyBluePurple3)) {
        // Display the chat messages with a vertical scrollbar

        val lazyColumnState = rememberLazyListState()

        LaunchedEffect(messageList) {
            if (messageList.isNotEmpty()) {
                val lastIndex = messageList.lastIndex
                lazyColumnState.scrollToItem(lastIndex)
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxHeight(0.54f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
            state = lazyColumnState
        ) {
            items(messageList) { message ->
                MessageItem(message, surname = mySurname.lastOrNull()?.surname)
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth().padding(horizontal = SpacingHalf_8dp)
            .background(BabyBluePurple2, RoundedCornerShape(34.dp))
            .padding(horizontal = SpacingCustom_6dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            OutlinedTextField(
                value = messageText,
                onValueChange = { messageText = it },
                modifier = Modifier
                    .weight(0.7f)
                    .padding(SpacingCustom_10dp),
                textStyle = TextStyle(color = contentColorFor(BabyBluePurple2), fontSize = 16.sp),
                label = { Text("Type your message", style = TextStyle(fontSize = 16.sp)) },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Send),
                keyboardActions = KeyboardActions(onSend = {
                    if (messageText.isNotEmpty()) {
                        viewModel.sendMessage(messageText)
                        messageText = ""
                    }
                }),
                singleLine = true,
                shape = RoundedCornerShape(16.dp), // Replace with the appropriate shape from Material2 if needed
                colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = BabyBluePurple2), // Replace with the appropriate colors from Material2 if needed
            )
            SendButton(
                onClick = {
                    if (messageText.isNotEmpty()) {
                        viewModel.sendMessage(messageText)
                        messageText = ""
                    }
                }
            )
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            LottieLoader(link = BASE_URL_LOTTIE_CHAT_lf20_END)
        }
    }
}

@Composable
fun SendButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        modifier = Modifier.background(FbColor, CircleShape),
        contentColor = Color.White,
        content = { Icon(Icons.Outlined.Send, null, tint = Color.White) },
        shape = CircleShape,
        elevation = FloatingActionButtonDefaults.elevation(0.dp, 4.dp),
        backgroundColor = FbColor
    )
}

@Composable
fun MessageItem(message: ChatMessage , surname : String?) {

        if(message.senderName == surname){
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(BabyBluePurple2, RoundedCornerShape(34.dp))
                    .padding(SpacingHalf_8dp),
            horizontalArrangement = Arrangement.End) {
                Text(
                    text = message.messageText,
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontWeight = FontWeight.Bold),

                )
            }
        }
        else{
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(BabyBluePurple2, RoundedCornerShape(34.dp))
                    .padding(SpacingHalf_8dp)) {
                Text(
                    text = "${message.senderName}: ${message.messageText}",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }

        }
}



data class ChatMessage(
    val userId: String = "",
    val senderName: String = "",
    val messageText: String = ""
)