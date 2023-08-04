package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.data

import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
    fun create() : SqlDriver
}