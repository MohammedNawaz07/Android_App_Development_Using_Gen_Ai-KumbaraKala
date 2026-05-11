package com.example.kumbarakala.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.kumbarakala.model.Product
import com.example.kumbarakala.ui.theme.ClayDark
import com.example.kumbarakala.ui.theme.ClayOrange

import androidx.compose.ui.res.painterResource

@Composable
fun DetailScreen(
    product: Product,
    onBackClick: () -> Unit,
    onGenerateStory: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(paddingValues = PaddingValues(24.dp))
    ) {
        // Image Gallery (Simplified)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(32.dp))
        ) {
            val painter = if (product.imageResId != null) {
                painterResource(id = product.imageResId)
            } else {
                rememberAsyncImagePainter(product.images.first())
            }

            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(Modifier.height(32.dp))

        // Title and Price
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column {
                Text(
                    product.material,
                    style = MaterialTheme.typography.labelSmall,
                    color = ClayOrange,
                    fontWeight = FontWeight.Bold
                )
                Text(product.name, style = MaterialTheme.typography.displayLarge, fontSize = 32.sp)
            }
            Text(product.price, style = MaterialTheme.typography.headlineMedium, color = ClayOrange)
        }

        Spacer(Modifier.height(16.dp))

        // Description Info Box
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            color = ClayOrange.copy(alpha = 0.05f),
            border = BorderStroke(1.dp, ClayOrange.copy(alpha = 0.1f))
        ) {
            Row(modifier = Modifier.padding(20.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Icon(Icons.Default.Info, contentDescription = null, tint = ClayOrange)
                Text(
                    product.description,
                    style = MaterialTheme.typography.bodyMedium,
                    fontStyle = FontStyle.Italic,
                    color = ClayDark.copy(alpha = 0.8f)
                )
            }
        }

        Spacer(Modifier.height(32.dp))

        // Benefits Grid
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            BenefitCard(
                title = "Healing Properties",
                items = product.healthBenefits,
                icon = Icons.Default.Favorite,
                tint = ClayOrange,
                modifier = Modifier.weight(1f)
            )
            BenefitCard(
                title = "Eco Footprint",
                items = product.ecoBenefits,
                icon = Icons.Default.Star,
                tint = Color(0xFF2E7D32),
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(Modifier.height(32.dp))

        // Cultural Value Card
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(32.dp),
            color = ClayDark
        ) {
            Column(modifier = Modifier.padding(32.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    "Ancestral Wisdom",
                    style = MaterialTheme.typography.labelSmall,
                    color = ClayOrange.copy(alpha = 0.5f)
                )
                Text(
                    "\"${product.culturalValue}\"",
                    style = MaterialTheme.typography.titleLarge,
                    fontStyle = FontStyle.Italic,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
        }

        Spacer(Modifier.height(32.dp))

        // Actions
        Button(
            onClick = onGenerateStory,
            modifier = Modifier.fillMaxWidth().height(64.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = ClayOrange)
        ) {
            Text("Compose Artisan Story", style = MaterialTheme.typography.titleLarge)
        }
    }
}

@Composable
fun BenefitCard(title: String, items: List<String>, icon: androidx.compose.ui.graphics.vector.ImageVector, tint: Color, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        color = Color.White,
        shadowElevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(24.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(icon, contentDescription = null, tint = tint, modifier = Modifier.size(16.dp))
                Text(title.uppercase(), style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
            }
            items.forEach { item ->
                Text("• $item", style = MaterialTheme.typography.labelSmall, fontSize = 10.sp, color = ClayDark.copy(alpha = 0.7f))
            }
        }
    }
}
