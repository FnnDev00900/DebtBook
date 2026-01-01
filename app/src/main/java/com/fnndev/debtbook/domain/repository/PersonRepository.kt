package com.fnndev.debtbook.domain.repository

import com.fnndev.debtbook.domain.model.Person
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    suspend fun insertPerson(person: Person)

    suspend fun updatePerson(person: Person)

    suspend fun deletePerson(person: Person)

    suspend fun getPersonById(id: Long): Person?

    fun getAllPersons(): Flow<List<Person>>
}