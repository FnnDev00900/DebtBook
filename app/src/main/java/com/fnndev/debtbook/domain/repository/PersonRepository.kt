package com.fnndev.debtbook.domain.repository

import com.fnndev.debtbook.data.local.entity.PersonEntity
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    suspend fun insertPerson(person: PersonEntity)

    suspend fun updatePerson(person: PersonEntity)

    suspend fun deletePerson(person: PersonEntity)

    fun getPersonById(id: Long): PersonEntity?

    fun getAllPersons(): Flow<List<PersonEntity>>
}