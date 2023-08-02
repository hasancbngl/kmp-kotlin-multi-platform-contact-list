package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.presentation

import androidx.compose.runtime.Composable

//implement this function differently for ios and android
@Composable
expect fun ContactsTheme(
    darkTheme:Boolean,
    dynamicColor:Boolean,
    content: @Composable ()->Unit
)