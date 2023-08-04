package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.platform.LocalContext
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.App
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.presentation.ImagePicker
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.presentation.ImagePickerFactory
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.di.AppModule

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                darkTheme = isSystemInDarkTheme(), dynamicColor = true,
                appModule = AppModule(LocalContext.current.applicationContext),
                imagePicker = ImagePickerFactory().createPicker()
            )
        }
    }
}