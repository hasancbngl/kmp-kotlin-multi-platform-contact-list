package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.di

import android.content.Context
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.data.SqlDelightContactDataSource
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain.ContactDataSource
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.data.DatabaseDriverFactory
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.database.ContactsDatabase

actual class AppModule(
    private val context: Context
) {
    actual val contactDataSource: ContactDataSource by lazy {
        SqlDelightContactDataSource(
            db = ContactsDatabase(
                DatabaseDriverFactory(context).create()
            )
        )
    }
}