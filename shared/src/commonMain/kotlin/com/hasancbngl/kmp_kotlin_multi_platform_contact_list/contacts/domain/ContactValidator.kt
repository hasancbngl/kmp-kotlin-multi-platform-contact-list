package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain

object ContactValidator {

    fun validateContact(contact: Contact): ValidationResult {
        var result = ValidationResult()
        val emailRegex = Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
        if (contact.firstName.isBlank()) {
            result = result.copy(
                firstNameError = "The first name can't be empty."
            )
        }

        if (contact.lastName.isBlank()) {
            result = result.copy(
                lastNameError = "The last name can't be empty."
            )
        }

        if (!emailRegex.matches(contact.email)) {
            result = result.copy(emailError = "This is not a valid email.")
        }

        if (contact.phoneNumber.isBlank() || contact.phoneNumber.toDoubleOrNull() == null) {
            result = result.copy(phoneNumberError = "This is not a valid phone number.")
        }
        return result
    }

    data class ValidationResult(
        val firstNameError: String? = null,
        val lastNameError: String? = null,
        val emailError: String? = null,
        val phoneNumberError: String? = null,
    )
}