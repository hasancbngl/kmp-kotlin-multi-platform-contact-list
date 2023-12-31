package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PersonAdd
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain.Contact
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.presentation.components.AddContactSheet
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.presentation.components.ContactDetailSheet
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.presentation.components.ContactListItem
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.presentation.components.RecentlyAddedContacts
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.presentation.ImagePicker

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactListScreen(
    state: ContactListState,
    newContact: Contact? = null,
    onEvent: (ContactListEvent) -> Unit,
    imagePicker: ImagePicker
) {
    imagePicker.registerPicker { imageBytes ->
        onEvent(ContactListEvent.OnPhotoPicked(imageBytes))
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEvent(ContactListEvent.OnAddNewContactClick)
                },
                shape = RoundedCornerShape(20.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.PersonAdd,
                    contentDescription = null
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                RecentlyAddedContacts(contacts = state.recentlyAddedContacts,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onEvent(ContactListEvent.SelectContact(it))
                    })
            }

            item {
                Text(
                    "My contacts (${state.contacts.size})",
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    fontWeight = FontWeight.Bold
                )
            }
            items(state.contacts) { contact ->
                ContactListItem(contact = contact, modifier = Modifier.fillMaxWidth().clickable {
                    onEvent(ContactListEvent.SelectContact(contact))
                }.padding(horizontal = 16.dp))
            }
        }
    }
    ContactDetailSheet(
        isOpen = state.isSelectedContactDetailSheetOpen,
        selectedContact = state.selectedContact,
        onEvent = onEvent
    )
    AddContactSheet(
        state = state,
        newContact = newContact,
        onEvent = { event ->
            if (event is ContactListEvent.OnAddPhotoClicked) imagePicker.pickImage()
            onEvent(event)
        },
        isOpen = state.isAddContactSheetOpen
    )
}