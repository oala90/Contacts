package com.example.contacts.di

import android.app.Activity
import android.content.ContentResolver
import android.content.Context
import com.example.contacts.data.local.provider.ContactProvider
import com.example.contacts.data.local.source.ContactLocalProviderSourceImpl
import com.example.contacts.presentation.utils.PhoneUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideContentResolver(@ApplicationContext context: Context): ContentResolver = context.contentResolver

//    @Singleton
//    @Provides
//    fun provideActivityContext(@ApplicationContext context: Context): Context = context

//    @Singleton
//    @Provides
//    fun providePhoneUtil(@ApplicationContext context: Context): PhoneUtil = PhoneUtil(context)
}