package com.example.mathapp.util

import android.content.Context
import android.widget.Toast

fun showToast(context: Context, message: Int) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun isValidInput(text: String): Boolean {
    // Remove leading and trailing whitespaces
    val trimmedText = text.trim()

    // Check if the trimmed text is empty
    return trimmedText.isNotEmpty()
}