package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun AddContactImageComposable(onClick: () -> Unit) {
    Box(
        Modifier.size(150.dp)
            .clip(RoundedCornerShape(40))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .clickable {
                onClick
            }
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = RoundedCornerShape(40)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = "Add photo",
            tint = MaterialTheme.colorScheme.onSecondaryContainer,
            modifier = Modifier.size(40.dp)
        )
    }
}