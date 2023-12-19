package com.example.contacts.domain.repository

import com.example.contacts.domain.entities.ContactEntity

interface ContactRepository {
   suspend fun getContact(): List<ContactEntity>
}