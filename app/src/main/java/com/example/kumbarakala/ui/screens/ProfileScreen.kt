package com.example.kumbarakala.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.kumbarakala.data.SampleData
import com.example.kumbarakala.ui.theme.ClayDark
import com.example.kumbarakala.ui.theme.ClayOrange
import androidx.compose.foundation.border
import androidx.compose.foundation.BorderStroke

@Composable
fun ProfileScreen(onLogout: () -> Unit) {
    val artisan = SampleData.SAMPLE_ARTISAN

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        // Profile Header Card
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(32.dp),
            color = Color.White,
            shadowElevation = 4.dp
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Header Background
                Box(modifier = Modifier.fillMaxWidth().height(128.dp).background(ClayDark))

                // Avatar
                Box(
                    modifier = Modifier
                        .offset(y = (-64).dp)
                        .size(160.dp)
                        .clip(RoundedCornerShape(40.dp))
                        .border(8.dp, Color.White, RoundedCornerShape(40.dp))
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(""), // User photo would go here
                        contentDescription = "Artisan",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                Column(
                    modifier = Modifier.offset(y = (-40).dp).padding(horizontal = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(artisan.name, style = MaterialTheme.typography.displayLarge, fontSize = 40.sp)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.width(32.dp).height(1.dp).background(ClayOrange))
                        Text(
                            " MASTER POTTER ",
                            style = MaterialTheme.typography.labelSmall,
                            color = ClayOrange,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 2.sp
                        )
                        Box(modifier = Modifier.width(32.dp).height(1.dp).background(ClayOrange))
                    }
                }

                // Info Section
                Column(
                    modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 40.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ProfileInfoRow("Artisan Roots", artisan.location)
                    ProfileInfoRow("Direct Connection", artisan.phone)

                    // About Card
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(48.dp),
                        color = ClayDark
                    ) {
                        Column(modifier = Modifier.padding(32.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            Text(
                                "The Artisan's Journey",
                                style = MaterialTheme.typography.labelSmall,
                                color = ClayOrange.copy(alpha = 0.5f)
                            )
                            Text(
                                "\"${artisan.about}\"",
                                style = MaterialTheme.typography.bodyMedium,
                                fontStyle = FontStyle.Italic,
                                color = Color.White.copy(alpha = 0.8f)
                            )
                        }
                    }
                }
            }
        }

        TextButton(onClick = { onLogout() }) {
            Text("Logout from Portal", color = ClayDark.copy(alpha = 0.4f), fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ProfileInfoRow(label: String, value: String) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(32.dp),
        color = Color(0xFFFFFBF7),
        border = BorderStroke(1.dp, ClayDark.copy(alpha = 0.05f))
    ) {
        Column(modifier = Modifier.padding(24.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(label, style = MaterialTheme.typography.labelSmall, color = ClayOrange)
            Text(value, style = MaterialTheme.typography.headlineMedium, fontSize = 18.sp)
        }
    }
}
