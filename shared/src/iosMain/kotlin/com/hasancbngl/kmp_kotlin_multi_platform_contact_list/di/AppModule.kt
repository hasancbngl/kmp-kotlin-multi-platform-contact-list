package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.di

import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.data.SqlDelightContactDataSource
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain.ContactDataSource
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.data.DatabaseDriverFactory
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.data.ImageStorage
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.database.ContactsDatabase

actual class AppModule {
    actual val contactDataSource: ContactDataSource by lazy {
        SqlDelightContactDataSource(
            db = ContactsDatabase(DatabaseDriverFactory().create()),
            imageStorage = ImageStorage()
        )
    }
}