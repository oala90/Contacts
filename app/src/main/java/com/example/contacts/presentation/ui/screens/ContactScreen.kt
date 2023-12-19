package com.example.contacts.presentation.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.contacts.domain.entities.ContactEntity

@Composable
fun ContactScreen(
    contacts: List<ContactEntity>,
    onItemClick: (ContactEntity) -> Unit
) {
    LazyColumn {
        items(contacts) { contact ->
            ContactItem(contact = contact) { clickedContact ->
                onItemClick(clickedContact)
            }
        }
    }
}