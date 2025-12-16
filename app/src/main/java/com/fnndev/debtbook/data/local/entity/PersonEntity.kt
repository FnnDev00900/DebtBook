package com.fnndev.debtbook.data.local.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val personId: Long = 0L,
    val fullName: String,
    val mobile: String? = null,
    val description: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)
