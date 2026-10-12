package com.example.a30jours
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.height
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.foundation.clickable
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically

data class WellnessDay(
    val day: Int,
    val title: String,
    val description: String
)

val wellnessDays = listOf(
    WellnessDay(1, "Drink Water", "Drink enough water throughout the day."),
    WellnessDay(2, "Take a Walk", "Take a short walk and move your body."),
    WellnessDay(3, "Get Enough Sleep", "Try to maintain a regular sleep schedule."),
    WellnessDay(4, "Eat Healthy", "Include fruits and vegetables in your meals."),
    WellnessDay(5, "Take a Break", "Take a few minutes to relax."),
    WellnessDay(6, "Stretch", "Stretch gently to relax your muscles."),
    WellnessDay(7, "Practice Gratitude", "Think about three things you appreciate."),
    WellnessDay(8, "Breathe Deeply", "Take a few slow and deep breaths."),
    WellnessDay(9, "Spend Time Outside", "Enjoy some fresh air."),
    WellnessDay(10, "Stay Connected", "Talk to a friend or family member."),
    WellnessDay(11, "Read a Book", "Spend a few minutes reading."),
    WellnessDay(12, "Listen to Music", "Listen to music you enjoy."),
    WellnessDay(13, "Keep Things Tidy", "Organize a small part of your space."),
    WellnessDay(14, "Smile More", "Share a smile with someone."),
    WellnessDay(15, "Eat Mindfully", "Take your time while eating."),
    WellnessDay(16, "Limit Screen Time", "Take a short break from your screen."),
    WellnessDay(17, "Learn Something", "Discover something new today."),
    WellnessDay(18, "Be Creative", "Draw, write, or make something."),
    WellnessDay(19, "Practice Kindness", "Do something kind for another person."),
    WellnessDay(20, "Relax Your Mind", "Take a quiet moment for yourself."),
    WellnessDay(21, "Move Your Body", "Choose an activity you enjoy."),
    WellnessDay(22, "Set a Goal", "Choose one small goal for today."),
    WellnessDay(23, "Enjoy Nature", "Notice the beauty around you."),
    WellnessDay(24, "Write Your Thoughts", "Write down how you feel."),
    WellnessDay(25, "Take a Digital Break", "Spend some time away from devices."),
    WellnessDay(26, "Drink Herbal Tea", "Enjoy a warm drink if you like."),
    WellnessDay(27, "Celebrate Progress", "Recognize something you have achieved."),
    WellnessDay(28, "Practice Patience", "Give yourself time to learn."),
    WellnessDay(29, "Enjoy a Hobby", "Make time for an activity you love."),
    WellnessDay(30, "Reflect and Relax", "Think about what you learned this month.")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                WellnessApp()
            }
        }
    }
}

@Composable
fun WellnessApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "30 Days of Wellness",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "Take care of yourself, one day at a time!",
                modifier = Modifier.padding(
                    top = 8.dp,
                    bottom = 16.dp
                ),
                style = MaterialTheme.typography.bodyLarge
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(wellnessDays) { day ->
                    DayCard(day = day)
                }
            }
        }
    }
}
@Composable
fun DayCard(day: WellnessDay) {
    var expanded by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (expanded) 1.02f else 1f,
        label = "cardScale"
    )

    val imageId = when (day.day) {
        1 -> R.drawable.day_1
        2 -> R.drawable.day_2
        3 -> R.drawable.day_3
        4 -> R.drawable.day_4
        5 -> R.drawable.day_5
        6 -> R.drawable.day_6
        7 -> R.drawable.day_7
        8 -> R.drawable.day_8
        9 -> R.drawable.day_9
        else -> null
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .clickable { expanded = !expanded }
            .animateContentSize(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            if (imageId != null) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = day.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(14.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = "Day ${day.day}",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = 12.dp)
            )

            Text(
                text = day.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = day.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 8.dp)
            )

            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn() + slideInVertically(
                    initialOffsetY = { it / 2 }
                )
            ) {
                Text(
                    text = "Take a moment for yourself today!",
                    modifier = Modifier.padding(top = 12.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}