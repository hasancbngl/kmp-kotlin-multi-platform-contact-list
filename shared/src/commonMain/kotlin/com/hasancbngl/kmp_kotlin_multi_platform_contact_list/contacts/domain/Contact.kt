package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain

data class Contact(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val photoBytes: ByteArray?
)
