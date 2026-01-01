package com.fnndev.debtbook.data.repository

import com.fnndev.debtbook.data.local.dao.PersonDao
import com.fnndev.debtbook.data.mapper.toDomain
import com.fnndev.debtbook.data.mapper.toEntity
import com.fnndev.debtbook.domain.model.Person
import com.fnndev.debtbook.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor(private val dao: PersonDao) : PersonRepository {
    override suspend fun insertPerson(person: Person) {
        dao.insertPerson(person.toEntity())
    }

    override suspend fun updatePerson(person: Person) {
        dao.updatePerson(person.toEntity())
    }

    override suspend fun deletePerson(person: Person) {
        dao.deletePerson(person.toEntity())
    }

    override suspend fun getPersonById(id: Long): Person? {
        return dao.getPersonById(id)?.toDomain()
    }

    override fun getAllPersons(): Flow<List<Person>> {
        return dao.getAllPersons().map { entities ->
            entities.map { it.toDomain() }
        }
    }
}