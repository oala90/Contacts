package com.example.contacts.data.local.provider

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.provider.ContactsContract
import com.example.contacts.data.model.ContactModel
import javax.inject.Inject

class ContactProvider @Inject constructor(
    private val contentResolver: ContentResolver,
) {
    private val contactList = mutableListOf<ContactModel>()

    private val projection = arrayOf(
        ContactsContract.Contacts._ID,
        ContactsContract.Contacts.DISPLAY_NAME,
        ContactsContract.Contacts.HAS_PHONE_NUMBER
    )

    private val cursor = contentResolver.query(
        ContactsContract.Contacts.CONTENT_URI,
        projection,
        null,
        null,
        null
    )

    @SuppressLint("Range", "SuspiciousIndentation")
    fun getContact(): List<ContactModel> {
        cursor?.use { cursor ->
            while (cursor.moveToNext()) {
                val contactId = cursor.getLong(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                val displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                val hasPhoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))

                if (hasPhoneNumber.toInt() > 0) {
                    val phoneCursor = contentResolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        "${ContactsContract.CommonDataKinds.Phone.CONTACT_ID} = ?",
                        arrayOf(contactId.toString()),
                        null
                        )

                        phoneCursor?.use { phone ->
                            if (phone.moveToFirst()) {
                                val phoneNumber = phone.getString(phone.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.NUMBER)
                                )
                                val contactModel = ContactModel(contactId, displayName, phoneNumber)
                                contactList.add(contactModel)
                            }
                        }
                } else {
                    val contactModel = ContactModel(contactId, displayName, "")
                    contactList.add(contactModel)
                }
            }
        }
        return contactList.toList()
    }
}