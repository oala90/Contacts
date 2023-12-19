package com.example.contacts.domain.usecases.contact

import com.example.contacts.domain.entities.ContactEntity
import com.example.contacts.domain.repository.ContactRepository
import com.example.contacts.domain.usecases.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetContactListUseCase @Inject constructor(
    private val repository: ContactRepository,
    background: CoroutineDispatcher
): UseCase<List<ContactEntity>, Unit>(background) {
    override suspend fun run(input: Unit?): List<ContactEntity> {
        return repository.getContact()
    }
}