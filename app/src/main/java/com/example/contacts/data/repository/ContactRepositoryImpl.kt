package com.example.contacts.data.repository

import com.example.contacts.data.mapper.toEntity
import com.example.contacts.data.model.ContactModel
import com.example.contacts.domain.entities.ContactEntity
import com.example.contacts.domain.repository.ContactRepository
import javax.inject.Inject

internal class ContactRepositoryImpl @Inject constructor(
    private val localSource: ContactLocalSource
): ContactRepository {
    override suspend fun getContact(): List<ContactEntity> {
        return localSource.getContact().toEntity()
    }

}

internal interface ContactLocalSource {
   suspend fun getContact(): List<ContactModel>
}