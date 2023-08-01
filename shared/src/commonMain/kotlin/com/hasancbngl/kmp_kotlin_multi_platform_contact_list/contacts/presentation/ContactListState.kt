package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.presentation

import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain.Contact

data class ContactListState(
    val contacts: List<Contact> = emptyList(),
    val recentlyAddedContact: List<Contact> = emptyList(),
    val selectedContact: Contact? = null,
    val isAddContactSheetOpen: Boolean = false,
    val isSelectedContactDetailSheetOpen: Boolean = false,
    val firstNameError: String? = null,
    val lastNameError: String? = null,
    val emailError: String? = null,
    val phoneNumberError: String? = null
)