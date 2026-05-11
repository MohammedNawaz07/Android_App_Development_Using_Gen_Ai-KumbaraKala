package com.example.kumbarakala.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.kumbarakala.ui.theme.ClayDark
import com.example.kumbarakala.ui.theme.ClayOrange

import androidx.compose.ui.res.painterResource
import com.example.kumbarakala.R
import com.example.kumbarakala.data.SampleData

@Composable
fun HomeScreen(
    onExploreClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        // Hero Image Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.8f)
                .clip(RoundedCornerShape(48.dp))
        ) {
            // Updated Image Logic:
            val painter = painterResource(id = R.drawable.home1) // REPLACE 'hero_pot' with your actual file name

            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, ClayDark.copy(alpha = 0.9f)),
                            startY = 400f
                        )
                    )
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(32.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Tradition Redefined",
                    color = Color.White.copy(alpha = 0.6f),
                    style = MaterialTheme.typography.labelSmall
                )
                Text(
                    text = "The Soul of\nEarthenware",
                    color = Color.White,
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 40.sp,
                    lineHeight = 36.sp
                )
                Text(
                    text = "Curated clay art from the heart of rural India.",
                    color = Color.White.copy(alpha = 0.7f),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        // Categories Hint
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Replace 'vessels_icon' and 'lamps_icon' with your actual file names in the drawable folder
            CategoryCard("Vessels", R.drawable.home2, Modifier.weight(1f))
            CategoryCard("Lamps", R.drawable.home3, Modifier.weight(1f))
        }
        // Support Local Art
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Support Local Art", style = MaterialTheme.typography.headlineMedium)
            Text(
                "Every piece you see is handcrafted by masters using techniques passed down through generations.",
                style = MaterialTheme.typography.bodyMedium,
                color = ClayDark.copy(alpha = 0.6f)
            )
        }

        Button(
            onClick = onExploreClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = ClayOrange)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Explore The Collection", style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.width(8.dp))
                Icon(Icons.Default.ArrowForward, contentDescription = null)
            }
        }

        // Stats
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            StatItem("12+", "Artisans")
            StatItem("500+", "Orders")
            StatItem("100%", "Organic")
        }
    }
}

@Composable
fun CategoryCard(label: String, imageResId: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(32.dp))
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f))
        )

        Text(
            text = label,
            modifier = Modifier.align(Alignment.Center),
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun StatItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, style = MaterialTheme.typography.headlineMedium)
        Text(label.uppercase(), style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
    }
}
