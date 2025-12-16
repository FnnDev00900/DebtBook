package com.fnndev.debtbook.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.fnndev.debtbook.data.local.entity.PersonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPerson(person: PersonEntity)

    @Update
    suspend fun updatePerson(person: PersonEntity)

    @Delete
    suspend fun deletePerson(person: PersonEntity)

    @Query("SELECT * FROM person_table WHERE personId = :id LIMIT 1")
    fun getPersonById(id: Long): PersonEntity?

    @Query("SELECT * FROM person_table Order by createdAt DESC")
    fun getAllPersons(): Flow<List<PersonEntity>>
}