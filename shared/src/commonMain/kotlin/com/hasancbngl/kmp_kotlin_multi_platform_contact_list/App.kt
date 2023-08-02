package com.hasancbngl.kmp_kotlin_multi_platform_contact_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.presentation.ContactListScreen
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.presentation.ContactListViewModel
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.presentation.ContactsTheme
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean,
) {
    val viewModel = getViewModel(
        key = "contact-list-screen",
        factory = viewModelFactory {
            ContactListViewModel()
        }
    )
    val state by viewModel.state.collectAsState()
    ContactsTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor
    ) {
        Surface(modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background) {
            ContactListScreen(
                state = state,
                newContact = viewModel.newContactHolder,
                onEvent = viewModel::OnEvent
            )
        }
    }
}