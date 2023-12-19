package com.example.contacts.presentation.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contacts.domain.entities.ContactEntity
import com.example.contacts.domain.usecases.contact.GetContactListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val getContactListUseCase: GetContactListUseCase
): ViewModel() {

    private val _contactList = MutableStateFlow<List<ContactEntity>>(emptyList())
    val contactList = _contactList.asStateFlow()
    //Paging 3

    var makeCallback: (() -> Unit)? = null

    fun getContactList() = viewModelScope.launch {
        getContactListUseCase().fold(
            { contactList ->
                _contactList.value = contactList
            }, {
                _contactList.value = emptyList()
            }
        )
    }

    fun makePhoneCall() {
        makeCallback?.invoke()
    }
}