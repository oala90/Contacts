package com.example.contacts.di

import com.example.contacts.domain.repository.ContactRepository
import com.example.contacts.domain.usecases.contact.GetContactListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun provideGetContactListUseCase(
        repository: ContactRepository,
        background: CoroutineDispatcher
    ) = GetContactListUseCase(repository, background)
}