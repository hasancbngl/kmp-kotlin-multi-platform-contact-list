package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

actual class ImagePickerFactory(
    private val rootController: UIViewController
){

    @Composable
    actual fun createPicker(): ImagePicker {
        return remember {
            ImagePicker(rootController)
        }
    }
}