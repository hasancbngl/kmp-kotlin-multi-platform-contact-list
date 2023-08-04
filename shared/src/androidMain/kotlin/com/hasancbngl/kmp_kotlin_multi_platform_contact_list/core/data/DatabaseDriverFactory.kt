package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.data

import android.content.Context
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.database.ContactsDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(
    private val context:Context
) {
    actual fun create(): SqlDriver {
       return AndroidSqliteDriver(
           ContactsDatabase.Schema,
           context,
           "contact.db"
       )
    }
}