package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.data

import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain.Contact
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain.ContactDataSource
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.database.ContactsDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SqlDelightContactDataSource(
    db: ContactsDatabase,
) : ContactDataSource {

    private val queries = db.contactQueries

    override fun getContacts(): Flow<List<Contact>> {
        return queries.getContacts()
            .asFlow()
            .mapToList()
            .map { contactList ->
                contactList.map { entity ->
                    entity.toContact()
                }
            }
    }

    override fun getRecentContacts(amount: Int): Flow<List<Contact>> {
        return queries.getRecentContacts(amount.toLong())
            .asFlow()
            .mapToList()
            .map { contactList ->
                contactList.map { entity ->
                    entity.toContact()
                }
            }
    }

    override suspend fun insertContact(contact: Contact) {
        queries.insertContactEntity(
            id = contact.id,
            firstName = contact.firstName,
            lastName = contact.lastName,
            email = contact.email,
            phoneNumber = contact.phoneNumber,
            createdAt = Clock.System.now().toEpochMilliseconds(),
            imagePath = null
        )
    }

    override suspend fun deleteContact(id: Long) {
        queries.deleteContact(id)
    }
}