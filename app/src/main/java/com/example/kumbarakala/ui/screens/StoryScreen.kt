package com.example.kumbarakala.ui.screens

import coil.compose.rememberAsyncImagePainter
import android.content.Intent
import android.net.Uri
import androidx.compose.animation.*
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kumbarakala.model.Product
import com.example.kumbarakala.ui.theme.ClayDark
import com.example.kumbarakala.ui.theme.ClayOrange
import kotlinx.coroutines.delay

@Composable
fun StoryScreen(
    product: Product,
    onBackClick: () -> Unit
) {
    var isGenerating by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(2000) // Simulate AI generation delay
        isGenerating = false
    }

    val context = LocalContext.current
    val artisanPhone = "+91 8951791240"

    // Exact requested format for WhatsApp
    val shareMessage = """
        *Pure ${product.name} Tradition 🍶*

        🍶 *${product.name}*

        ✨ *Health Benefits:*
        ${product.healthBenefits.joinToString("\n") { "• $it" }}

        🌍 *Eco-Friendly:*
        ${product.ecoBenefits.joinToString("\n") { "• $it" }}

        🏛️ *Culture:* ${product.culturalValue}

        👨🎨 *Artisan:* Mohammed Nawaz
        📞 *Contact:* $artisanPhone

        💡 _Stay healthy, choose the earth. Buy your clay pot today!!_
    """.trimIndent()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F7F4))
            .verticalScroll(rememberScrollState())
    ) {
        // Toolbar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.background(Color.White, RoundedCornerShape(12.dp))
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = ClayDark)
            }
            Text(
                "Artisan Heritage",
                style = MaterialTheme.typography.labelSmall,
                color = ClayOrange,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )
            IconButton(
                onClick = {
                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, shareMessage)
                        type = "text/plain"
                    }
                    val shareIntent = Intent.createChooser(sendIntent, null)
                    context.startActivity(shareIntent)
                },
                modifier = Modifier.background(Color.White, RoundedCornerShape(12.dp))
            ) {
                Icon(Icons.Default.Share, contentDescription = "Share", tint = ClayDark)
            }
        }

        if (isGenerating) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    CircularProgressIndicator(color = ClayOrange)
                    Text(
                        "Weaving the artisan's tale...",
                        style = MaterialTheme.typography.bodyMedium,
                        fontStyle = FontStyle.Italic,
                        color = ClayDark.copy(alpha = 0.5f)
                    )
                }
            }
        } else {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + expandVertically()
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    // Story Title Card with Product Image
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(32.dp),
                        color = ClayDark
                    ) {
                        Column {
                            // Added Product Image to Story Card
                            Box(modifier = Modifier.fillMaxWidth().height(200.dp)) {
                                val painter = if (product.imageResId != null) {
                                    painterResource(id = product.imageResId)
                                } else {
                                    rememberAsyncImagePainter(product.imageName)
                                }
                                androidx.compose.foundation.Image(
                                    painter = painter,
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = androidx.compose.ui.layout.ContentScale.Crop
                                )
                                Box(modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.3f)))
                            }

                            Column(modifier = Modifier.padding(24.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Text(
                                    "Soul Of Clay",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = ClayOrange.copy(alpha = 0.6f)
                                )
                                Text(
                                    "The Legacy of the ${product.name}",
                                    style = MaterialTheme.typography.headlineMedium,
                                    color = Color.White,
                                    fontSize = 28.sp,
                                    lineHeight = 32.sp
                                )
                            }
                        }
                    }

                    // Main Story Body
                    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                        Text(
                            "In the quiet workshops of Karkala, where the scent of wet earth lingers in the air, a master's hands dance with the wheel. This ${product.name} isn't just a vessel; it's a whisper from the past, crafted from ${product.material} that has seen a thousand monsoons.",
                            style = MaterialTheme.typography.bodyMedium,
                            lineHeight = 28.sp,
                            color = ClayDark.copy(alpha = 0.8f)
                        )
                    }

                    // Connect Section
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 60.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            "Share Traditional Wisdom",
                            style = MaterialTheme.typography.titleLarge,
                            color = ClayDark,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            ShareActionCard(
                                label = "WhatsApp",
                                icon = Icons.Default.Send,
                                color = Color(0xFF25D366),
                                modifier = Modifier.weight(1f),
                                onClick = {
                                    val uri = Uri.parse("https://api.whatsapp.com/send?phone=$artisanPhone&text=${Uri.encode(shareMessage)}")
                                    val intent = Intent(Intent.ACTION_VIEW, uri)
                                    context.startActivity(intent)
                                }
                            )
                            ShareActionCard(
                                label = "SMS",
                                icon = Icons.Default.Email,
                                color = ClayOrange,
                                modifier = Modifier.weight(1f),
                                onClick = {
                                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                                        data = Uri.parse("smsto:$artisanPhone")
                                        putExtra("sms_body", shareMessage)
                                    }
                                    context.startActivity(intent)
                                }
                            )
                            ShareActionCard(
                                label = "Email",
                                icon = Icons.Default.MailOutline,
                                color = ClayDark,
                                modifier = Modifier.weight(1f),
                                onClick = {
                                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                                        data = Uri.parse("mailto:mohammednawaz0702@gmail.com")
                                        putExtra(Intent.EXTRA_SUBJECT, "Artisan Heritage Story: ${product.name}")
                                        putExtra(Intent.EXTRA_TEXT, shareMessage)
                                    }
                                    context.startActivity(intent)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ShareActionCard(
    label: String,
    icon: ImageVector,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        modifier = modifier.height(100.dp),
        shape = RoundedCornerShape(24.dp),
        color = Color.White,
        shadowElevation = 2.dp,
        border = BorderStroke(1.dp, ClayDark.copy(alpha = 0.05f))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = color,
                modifier = Modifier.size(24.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = ClayDark.copy(alpha = 0.6f)
            )
        }
    }
}

@Composable
fun ImpactBadge(label: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(ClayOrange.copy(alpha = 0.1f))
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            label.uppercase(),
            style = MaterialTheme.typography.labelSmall,
            color = ClayOrange,
            fontWeight = FontWeight.Bold,
            fontSize = 9.sp
        )
    }
}
