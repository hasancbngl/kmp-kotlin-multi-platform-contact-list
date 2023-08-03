package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain

import kotlinx.coroutines.flow.Flow

interface ContactDataSource {
    fun getContacts(): Flow<List<Contact>>
    fun getRecentContacts(amount: Int): Flow<List<Contact>>
    suspend fun insertContact(contact: Contact)
    suspend fun deleteContact(id: Long)
}