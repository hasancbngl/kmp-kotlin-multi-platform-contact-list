package com.hasancbngl.kmp_kotlin_multi_platform_contact_list

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform