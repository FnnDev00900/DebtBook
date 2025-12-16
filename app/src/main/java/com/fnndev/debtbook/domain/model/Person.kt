package com.fnndev.debtbook.domain.model

data class Person(
    val personId: Long = 0L,
    val fullName: String,
    val mobile: String? = null,
    val description: String? = null,
)
