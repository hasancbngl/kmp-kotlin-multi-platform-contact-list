package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain.Contact
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContactListViewModel : ViewModel() {

    private val _state = MutableStateFlow(ContactListState(
        contacts = contacts
    ))
    val state: StateFlow<ContactListState> = _state.asStateFlow()
    var newContactHolder: Contact? by mutableStateOf(null)
        private set

    fun OnEvent(event: ContactListEvent){

    }
}

private val contacts = (1..50).map {
    Contact(
        id = it.toLong(),
        firstName = "First$it",
        lastName = "Last$it",
        phoneNumber = "123456465",
        email = "test@$it.com",
        photoBytes = null,
    )
}