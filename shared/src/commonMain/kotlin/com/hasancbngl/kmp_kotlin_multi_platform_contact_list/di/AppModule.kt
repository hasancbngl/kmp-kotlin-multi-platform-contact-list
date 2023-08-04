package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.di

import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain.ContactDataSource

expect class AppModule {
    val contactDataSource: ContactDataSource
}