package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.ui.theme.DarkColorScheme
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.ui.theme.LightColorScheme
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.ui.theme.Typography

@Composable
actual fun ContactsTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        content = content,
        typography = Typography
    )
}