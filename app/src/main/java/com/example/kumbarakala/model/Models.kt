package com.example.kumbarakala.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: String,
    val name: String,
    val description: String,
    val usage: String,
    val price: String,
    val healthBenefits: List<String>,
    val ecoBenefits: List<String>,
    val culturalValue: String,
    val imageName: String,
    val imageResId: Int? = null,
    val images: List<String>,
    val material: String
) : Parcelable

@Parcelize
data class Artisan(
    val name: String,
    val location: String,
    val phone: String,
    val about: String,
    val productsMade: List<String>
) : Parcelable

@Parcelize
data class ProductStory(
    val id: String? = null,
    val productId: String,
    val title: String,
    val content: String,
    val healthBenefits: List<String>,
    val ecoBenefits: List<String>,
    val culturalValue: String,
    val encouragement: String,
    val artisanName: String,
    val contactNumber: String,
    val userId: String,
    val createdAt: Long
) : Parcelable
