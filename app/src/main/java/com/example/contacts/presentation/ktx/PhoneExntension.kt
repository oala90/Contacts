package com.example.contacts.presentation.ktx

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.app.ActivityCompat
import androidx.core.app.ComponentActivity

//In java we call this "PhoneUtil", in kotlin we use extension function ad we call PhoneExtension
const val CALL_PHONE_PERMISSION_REQUEST_CODE = 123
fun Context.hasCallPhonePermission(): Boolean {
        if (
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this as Activity,
                arrayOf(Manifest.permission.CALL_PHONE),
                CALL_PHONE_PERMISSION_REQUEST_CODE
            )

            return false
        } else {
            return true
        }
}

fun ComponentActivity.startCallIntent(phoneNumber: String) {
    if(!hasCallPhonePermission()) {
        return
    }
    val callIntent = Intent(Intent.ACTION_CALL)
    callIntent.data = Uri.parse("tel:$phoneNumber")
    callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(callIntent)
}



