package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.data

expect class ImageStorage {
    suspend fun saveImage(bytes: ByteArray): String
    suspend fun getImage(fileName: String): ByteArray?
    suspend fun deleteImage(fileName: String)
}