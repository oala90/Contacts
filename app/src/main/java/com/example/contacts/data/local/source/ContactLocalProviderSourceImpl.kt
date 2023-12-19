package com.example.contacts.data.local.source

import com.example.contacts.data.local.provider.ContactProvider
import com.example.contacts.data.model.ContactModel
import com.example.contacts.data.repository.ContactLocalSource
import javax.inject.Inject

internal class ContactLocalProviderSourceImpl @Inject constructor(
    private val contactProvider: ContactProvider
): ContactLocalSource {
    override suspend fun getContact(): List<ContactModel> {
        return contactProvider.getContact()
    }
}