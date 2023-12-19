package com.example.contacts.di

import com.example.contacts.data.local.source.ContactLocalProviderSourceImpl
import com.example.contacts.data.repository.ContactLocalSource
import com.example.contacts.data.repository.ContactRepositoryImpl
import com.example.contacts.domain.repository.ContactRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindContactLocalDataSource(
        contactLocalProviderSourceImpl: ContactLocalProviderSourceImpl
    ): ContactLocalSource

    @Binds
    internal abstract fun bindContactRepository(
        contactRepositoryImpl: ContactRepositoryImpl
    ): ContactRepository
}