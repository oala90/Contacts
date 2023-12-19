package com.example.contacts.presentation.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.app.ActivityCompat
import java.lang.ref.WeakReference

class PhoneUtil (
    private val activity: Context
) {

    private val activityContextRef: WeakReference<Context> = WeakReference(activity)

    fun makeCall(phoneNumber: String) {
        val activityContext = activityContextRef.get()
        if (activityContext != null) {
            if (
                ActivityCompat.checkSelfPermission(
                    activity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    activity as Activity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    CALL_PHONE_PERMISSION_REQUEST_CODE
                )
            } else {
                startCallIntent(phoneNumber)
            }
        }
    }

    private fun startCallIntent(phoneNumber: String) {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:$phoneNumber")
        callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        activity.startActivity(callIntent)
    }

    companion object {
        const val CALL_PHONE_PERMISSION_REQUEST_CODE = 123
    }
}