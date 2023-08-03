package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.data

import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain.Contact
import database.ContactEntity

fun ContactEntity.toContact(): Contact {
    return Contact(
        id = id,
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email,
        photoBytes = null
    )
}