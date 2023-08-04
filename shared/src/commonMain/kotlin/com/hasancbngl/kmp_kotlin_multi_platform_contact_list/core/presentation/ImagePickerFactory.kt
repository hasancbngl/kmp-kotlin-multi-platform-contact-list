package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.presentation

import androidx.compose.runtime.Composable

expect class ImagePickerFactory {
    @Composable
    fun createPicker(): ImagePicker
}