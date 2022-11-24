package com.example.mathapp.ui.unit.enums

sealed class TheoryButtonItems(var text: String, var onClickAction: String) {

    object test1 : TheoryButtonItems("test1", "test")
}