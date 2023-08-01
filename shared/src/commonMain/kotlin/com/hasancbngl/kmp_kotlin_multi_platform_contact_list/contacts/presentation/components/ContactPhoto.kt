package com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.contacts.domain.Contact
import com.hasancbngl.kmp_kotlin_multi_platform_contact_list.core.presentation.rememberBitmapFromBytes

@Composable
fun ContactPhoto(
    contact: Contact? = null,
    modifier: Modifier = Modifier,
    iconSize: Dp = 25.dp
) {
    val bitmap = rememberBitmapFromBytes(contact?.photoBytes)
    val photoModifier = modifier.clip(RoundedCornerShape(35))

    if (bitmap != null) {
        Image(
            bitmap = bitmap,
            contentScale = ContentScale.Crop,
            modifier = photoModifier,
            contentDescription = contact?.firstName
        )
    } else {
        Box(
            modifier = photoModifier
                .background(MaterialTheme.colorScheme.secondaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.Person,
                contentDescription = contact?.firstName,
                modifier = Modifier.size(iconSize),
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}