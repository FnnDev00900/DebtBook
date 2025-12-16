package com.fnndev.debtbook.data.repository

import com.fnndev.debtbook.data.local.dao.PersonDao
import com.fnndev.debtbook.data.local.entity.PersonEntity
import com.fnndev.debtbook.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor(private val dao: PersonDao) : PersonRepository {
    override suspend fun insertPerson(person: PersonEntity) {
        dao.insertPerson(person)
    }

    override suspend fun updatePerson(person: PersonEntity) {
        dao.updatePerson(person)
    }

    override suspend fun deletePerson(person: PersonEntity) {
        dao.deletePerson(person)
    }

    override fun getPersonById(id: Long): PersonEntity? {
        return dao.getPersonById(id)
    }

    override fun getAllPersons(): Flow<List<PersonEntity>> {
        return dao.getAllPersons()
    }
}