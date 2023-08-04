package com.hasancbngl.kmp_kotlin_multi_platform_contact_list

import androidx.compose.ui.window.ComposeUIViewController
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.di.AppModule

//run only in ios
fun MainViewController() = ComposeUIViewController {
    val isDarkTheme =
        UIScreen.mainScreen.traitCollection.userInterfaceStyle ==
                UIUserInterfaceStyle.UIUserInterfaceStyleDark
    App(
        darkTheme = isDarkTheme,
        dynamicColor = false,
        appModule = AppModule()
    )
}