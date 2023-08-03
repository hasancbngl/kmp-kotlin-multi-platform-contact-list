package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain.Contact
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain.ContactDataSource
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ContactListViewModel(
    private val contactDataSource: ContactDataSource
) : ViewModel() {

    private val _state = MutableStateFlow(ContactListState())
    val state: StateFlow<ContactListState> = combine(
        _state,
        contactDataSource.getContacts(),
        contactDataSource.getRecentContacts(20)
    ) { state, contacts, recentContacts ->
        state.copy(
            contacts = contacts,
            recentlyAddedContacts = recentContacts
        )
    }.stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(500L),
        ContactListState()
    )

    var newContactHolder: Contact? by mutableStateOf(null)
        private set

    fun OnEvent(event: ContactListEvent) {
        when (event) {
            ContactListEvent.DeleteContact -> {
                viewModelScope.launch {
                    _state.value.selectedContact?.id?.let { id ->
                        _state.update {
                            it.copy(
                                isSelectedContactDetailSheetOpen = false
                            )
                        }
                        contactDataSource.deleteContact(id)
                        delay(300L)
                        _state.update {
                            it.copy(
                                selectedContact = null
                            )
                        }
                    }
                }
            }

            ContactListEvent.DismissContact -> {
                viewModelScope.launch {
                    _state.update {
                        it.copy(
                            isSelectedContactDetailSheetOpen = false,
                            isAddContactSheetOpen = false,
                            firstNameError = null
                        )
                    }
                    delay(300)
                    newContactHolder = null
                    _state.update {
                        it.copy(
                            selectedContact = null
                        )
                    }
                }
            }

            is ContactListEvent.EditContact -> {
                _state.update {
                    it.copy(
                        selectedContact = null,
                        isAddContactSheetOpen = true,
                        isSelectedContactDetailSheetOpen = false
                    )
                }
                newContactHolder = event.contact
            }

            ContactListEvent.OnAddNewContactClick -> {
                _state.update {
                    it.copy(
                        isAddContactSheetOpen = true
                    )
                }
                newContactHolder = Contact(
                    id = null,
                    firstName = "",
                    lastName = "",
                    phoneNumber = "",
                    email = "",
                    photoBytes = null,
                )
            }

            is ContactListEvent.OnEmailChanged -> {
                newContactHolder = newContactHolder?.copy(
                    email = event.value
                )
            }

            is ContactListEvent.OnFirstNameChanged -> {
                newContactHolder = newContactHolder?.copy(
                    firstName = event.value
                )
            }

            is ContactListEvent.OnLastNameChanged -> {
                newContactHolder = newContactHolder?.copy(
                    lastName = event.value
                )
            }

            is ContactListEvent.OnPhoneNumberChanged -> {
                newContactHolder = newContactHolder?.copy(
                    phoneNumber = event.value
                )
            }
            is ContactListEvent.OnPhotoPicked -> {
                newContactHolder = newContactHolder?.copy(
                    photoBytes = event.bytes
                )
            }
            ContactListEvent.SaveContact -> {
                viewModelScope.launch {
                    newContactHolder?.let { contactDataSource.insertContact(it) }
                }
            }

            is ContactListEvent.SelectContact -> {
                _state.update {
                    it.copy(
                        selectedContact = event.contact,
                        isSelectedContactDetailSheetOpen = true
                    )
                }
            }
        }
    }
}