package com.example.kumbarakala

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.kumbarakala.model.Product
import com.example.kumbarakala.ui.screens.*
import com.example.kumbarakala.ui.theme.KumbaraKalaTheme

sealed class Screen {
    object Home : Screen()
    object Catalog : Screen()
    data class Detail(val product: Product) : Screen()
    object Profile : Screen()
    object Story : Screen()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KumbaraKalaTheme {
                MainApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {
    var isLoggedIn by remember { mutableStateOf(false) }
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }
    var selectedProduct by remember { mutableStateOf<Product?>(null) }

    if (!isLoggedIn) {
        LoginScreen(onLoginSuccess = { isLoggedIn = true })
    } else {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    val items = listOf(
                        Triple("Home", Icons.Default.Home, Screen.Home),
                        Triple("Gallery", Icons.Default.ShoppingCart, Screen.Catalog),
                        Triple("Artisan", Icons.Default.Person, Screen.Profile)
                    )
                    items.forEach { (label, icon, screen) ->
                        val isSelected = when (screen) {
                            is Screen.Home -> currentScreen is Screen.Home
                            is Screen.Catalog -> currentScreen is Screen.Catalog
                            is Screen.Profile -> currentScreen is Screen.Profile
                            else -> false
                        }
                        NavigationBarItem(
                            icon = { Icon(icon, contentDescription = label) },
                            label = { Text(label) },
                            selected = isSelected,
                            onClick = {
                                currentScreen = screen
                            }
                        )
                    }
                }
            }
        ) { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                color = MaterialTheme.colorScheme.background
            ) {
                when (val screen = currentScreen) {
                    is Screen.Home -> HomeScreen(
                        onExploreClick = { currentScreen = Screen.Catalog },
                        onProfileClick = { currentScreen = Screen.Profile }
                    )
                    is Screen.Catalog -> CatalogScreen(
                        onProductClick = { product ->
                            selectedProduct = product
                            currentScreen = Screen.Detail(product)
                        }
                    )
                    is Screen.Detail -> DetailScreen(
                        product = screen.product,
                        onBackClick = { currentScreen = Screen.Catalog },
                        onGenerateStory = {
                            selectedProduct = screen.product
                            currentScreen = Screen.Story
                        }
                    )
                    is Screen.Profile -> ProfileScreen(onLogout = { isLoggedIn = false })
                    is Screen.Story -> selectedProduct?.let { product ->
                        StoryScreen(
                            product = product,
                            onBackClick = { currentScreen = Screen.Detail(product) }
                        )
                    } ?: HomeScreen(onExploreClick = { currentScreen = Screen.Catalog }, onProfileClick = { currentScreen = Screen.Profile })
                }
            }
        }
    }
}
