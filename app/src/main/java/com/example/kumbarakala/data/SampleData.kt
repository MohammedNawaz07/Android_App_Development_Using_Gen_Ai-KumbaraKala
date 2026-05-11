package com.example.kumbarakala.data

import com.example.kumbarakala.model.Artisan
import com.example.kumbarakala.model.Product

import com.example.kumbarakala.R

object SampleData {
    // Hero Image Reference (Update 'hero_pot' to your actual file name in drawable)
    val HERO_IMAGE_RES = R.drawable.home1

    val SAMPLE_PRODUCTS = listOf(
        Product(
            id = "p1",
            name = "Clay Water Pot",
            description = "Traditional earthenware pot with a convenient brass tap for natural cooling.",
            usage = "Storing and naturally cooling drinking water",
            price = "₹650",
            material = "Traditional Red Clay",
            healthBenefits = listOf(
                "Naturally Alkaline: Balances pH level",
                "Evaporative Cooling: Gentle on the throat",
                "Essential Minerals: Infuses water with magnesium and iron"
            ),
            ecoBenefits = listOf(
                "100% Biodegradable Materials",
                "Zero Energy Cooling"
            ),
            culturalValue = "An ancient symbol of Indian hospitality and pure living.",
            imageName = "https://images.unsplash.com/photo-1610450954853-2746ebc68707?auto=format&fit=crop&q=80&w=1200",
            imageResId = R.drawable.wpot2, // Replace with your file name
            images = listOf(
                "https://images.unsplash.com/photo-1610450954853-2746ebc68707?auto=format&fit=crop&q=80&w=1200"
            ),
        ),
        Product(
            id = "p2",
            name = "Clay Lamp",
            description = "Finely etched lamps designed for spiritual serenity and warm ambiance.",
            usage = "Meditation and festival lighting",
            price = "₹240 (Set of 4)",
            material = "Fine Potters Basin Clay",
            healthBenefits = listOf(
                "Soothes eyes with yellow spectrum light",
                "Non-toxic organic clay base"
            ),
            ecoBenefits = listOf(
                "Sustainable alternative to paraffin",
                "Supports zero-waste lifestyle"
            ),
            culturalValue = "Dispelling darkness and celebrating inner light.",
            imageName = "https://images.unsplash.com/photo-1635952671046-e578c767e727?auto=format&fit=crop&q=80&w=1200",
            imageResId = R.drawable.lamp2,

            images = listOf(
                "https://images.unsplash.com/photo-1635952671046-e578c767e727?auto=format&fit=crop&q=80&w=1200",
                "https://images.unsplash.com/photo-1605335122396-857e4e1379ec?auto=format&fit=crop&q=80&w=1200",
                "https://images.unsplash.com/photo-1505934333218-8ee075f0868f?auto=format&fit=crop&q=80&w=1200"
            ),
        ),
        Product(
            id = "p3",
            name = "Clay Cup",
            description = "Elegant artisanal cups that breathe life into your tea with earthy notes.",
            usage = "Daily tea and coffee time",
            price = "₹150",
            material = "High-fired Terracotta",
            healthBenefits = listOf(
                "Improves digestion naturally",
                "BPA and chemical-free serving"
            ),
            ecoBenefits = listOf(
                "Brings an end to plastic cup waste",
                "Locally sourced materials"
            ),
            culturalValue = "The authentic 'Chai-Kulhad' experience.",
            imageName = "https://images.unsplash.com/photo-1574672280600-4accfa5b6f98?auto=format&fit=crop&q=80&w=1200",
            imageResId = R.drawable.cup3,

            images = listOf(
                "https://images.unsplash.com/photo-1574672280600-4accfa5b6f98?auto=format&fit=crop&q=80&w=1200",
                "https://images.unsplash.com/photo-1589923158776-cb4485d99fd6?auto=format&fit=crop&q=80&w=1200",
                "https://images.unsplash.com/photo-1514362545857-3bc16c4c7d1b?auto=format&fit=crop&q=80&w=1200"
            ),
        ),
        Product(
            id = "p4",
            name = "Clay Plate",
            description = "A wide, rustic dining plate that makes every meal feel like a ritual.",
            usage = "Serving main course Indian meals",
            price = "₹350",
            material = "Hand-pressed Riverbed Clay",
            healthBenefits = listOf(
                "Maintains food warmth naturally",
                "Naturally prevents acidity"
            ),
            ecoBenefits = listOf(
                "Chemical-free dining lifestyle",
                "Biodegradable at end of life"
            ),
            culturalValue = "Dining wisdom passed through generations.",
            imageName = "https://images.unsplash.com/photo-1610701596007-11502861dcfa?auto=format&fit=crop&q=80&w=1200",
            imageResId = R.drawable.plate2,
            images = listOf(
                "https://images.unsplash.com/photo-1610701596007-11502861dcfa?auto=format&fit=crop&q=80&w=1200",
                "https://images.unsplash.com/photo-1594911772124-d1d643807908?auto=format&fit=crop&q=80&w=1200",
                "https://images.unsplash.com/photo-1498579687545-d5a4fffb0a9e?auto=format&fit=crop&q=80&w=1200"
            ),
        ),
        Product(
            id = "p5",
            name = "Clay Cooking Pot",
            description = "Deep, fire-resistant pot perfect for slow-cooked authentic curries.",
            usage = "Slow-simmering stews and soups",
            price = "₹850",
            material = "Reinforced Fire-proof Clay",
            healthBenefits = listOf(
                "Locks in natural food moisture",
                "Requires significantly less oil"
            ),
            ecoBenefits = listOf(
                "Retains heat, saving fuel",
                "Crafted using renewable methods"
            ),
            culturalValue = "The soul of a traditional village kitchen.",
            imageName = "https://images.unsplash.com/photo-1582234372722-50d7ccc30ebd?auto=format&fit=crop&q=80&w=1200",
            imageResId = R.drawable.cpot3,
            images = listOf(
                "https://images.unsplash.com/photo-1582234372722-50d7ccc30ebd?auto=format&fit=crop&q=80&w=1200",
                "https://images.unsplash.com/photo-1466633393035-3d5f3074360e?auto=format&fit=crop&q=80&w=1200",
                "https://images.unsplash.com/photo-1593001872118-2e861d8583fb?auto=format&fit=crop&q=80&w=1200"
            ),
        ),
        Product(
            id = "p6",
            name = "Clay Flower Vase",
            description = "A decorative masterpiece that brings organic beauty to any corner.",
            usage = "Home decor and fresh arrangements",
            price = "₹550",
            material = "Fine Alluvial Clay",
            healthBenefits = listOf(
                "Porous walls help flowers breathe",
                "Plastic-free home environment"
            ),
            ecoBenefits = listOf(
                "Authentic artisanal alternative",
                "Non-industrial production"
            ),
            culturalValue = "Harmony between nature and home.",
            imageName = "https://images.unsplash.com/photo-1584622650111-993a426fbf0a?auto=format&fit=crop&q=80&w=1200",
            imageResId = R.drawable.vase2,

            images = listOf(
                "https://images.unsplash.com/photo-1584622650111-993a426fbf0a?auto=format&fit=crop&q=80&w=1200",
                "https://images.unsplash.com/photo-1490312278390-ab6414ef8bb9?auto=format&fit=crop&q=80&w=1200",
                "https://images.unsplash.com/photo-1518199266791-5375a83190b7?auto=format&fit=crop&q=80&w=1200"
            ),
        )
    )

    val SAMPLE_ARTISAN = Artisan(
        name = "Mohammed Nawaz",
        location = "Karkala, Karnataka, India - 576117",
        phone = "+91 8951791240",
        about = "Mohammed is a dedicated promoter of traditional craftsmanship in Karnataka. He works closely with local potters to bring the health and cooling benefits of natural clay into modern homes, bridging the gap between ancient wisdom and digital reach.",
        productsMade = listOf("Water Pots", "Cooking Vessels", "Artisanal Decor")
    )
}
