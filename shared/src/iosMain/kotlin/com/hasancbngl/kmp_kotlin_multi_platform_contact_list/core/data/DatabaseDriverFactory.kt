package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.data

import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.database.ContactsDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
      return NativeSqliteDriver(
          ContactsDatabase.Schema,
          "contact.db"
      )
    }
}