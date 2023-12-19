package com.example.contacts.data.mapper

import com.example.contacts.data.model.ContactModel
import com.example.contacts.domain.entities.ContactEntity

fun List<ContactModel>.toEntity() = this.map {
    ContactEntity(
        id = it.id,
        name = it.name,
        phoneNumber = it.phoneNumber
    )
}