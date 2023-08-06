package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.data

import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain.Contact
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.data.ImageStorage
import database.ContactEntity

suspend fun ContactEntity.toContact(imageStorage: ImageStorage): Contact {
    return Contact(
        id = id,
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email,
        photoBytes = imagePath?.let {
            imageStorage.getImage(it)
        }
    )
}