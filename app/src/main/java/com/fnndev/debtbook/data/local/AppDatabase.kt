package com.fnndev.debtbook.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fnndev.debtbook.data.local.dao.PersonDao
import com.fnndev.debtbook.data.local.entity.PersonEntity

@Database(
    entities = [PersonEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract val personDao: PersonDao
}