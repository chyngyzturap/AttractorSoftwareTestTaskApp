package com.chyngyzturapov.testapp.ui

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContentProviderCompat.requireContext

public fun getEducation(id: Int): String {
    var education = ""
    when (id) {
        1 -> {
            education = "high_school"
        }
        2 -> {
            education = "bachelor"
        }
        3 -> {
            education = "master"
        }
        4 -> {
            education = "doctoral"
        }
    }
    return education
}

public fun getFullName(firstName: String, secondName: String): String {
    var username = ""
    if (firstName.isNotEmpty() && secondName.isNotEmpty())
        username = "$firstName $secondName"
    if (firstName.isNotEmpty() && secondName.isEmpty())
        username = firstName
    if (firstName.isEmpty() && secondName.isNotEmpty())
        username = secondName

    return username
}

public fun getPermission(context: Activity) {
    val colum = arrayOf<String>(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )
    if ((ActivityCompat.checkSelfPermission(
            context, colum[0]
        ) != PackageManager.PERMISSION_GRANTED) &&
        (ActivityCompat.checkSelfPermission(
            context, colum[1]
        ) != PackageManager.PERMISSION_GRANTED)
    ) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(context, colum, 123)
        }
    }
}
public fun checkPermission(context: Activity): Boolean {
    val colum = arrayOf<String>(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )
    var isPermitted = false
    if ((ActivityCompat.checkSelfPermission(
            context, colum[0]
        ) == PackageManager.PERMISSION_GRANTED) &&
        (ActivityCompat.checkSelfPermission(
            context, colum[1]
        ) == PackageManager.PERMISSION_GRANTED)
    ) {
        isPermitted = true
    } else {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(context, colum, 123)
        }
    }
    return isPermitted
}


