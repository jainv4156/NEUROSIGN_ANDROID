package co.spacece.neurosign.Home.Products.Assessment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import co.spacece.neurosign.R
import co.spacece.neurosign.ui.theme.Light
import co.spacece.neurosign.ui.theme.Primary
import co.spacece.neurosign.ui.theme.WarningColor

// Problem in UI
@Composable
fun WelcomeAssessment(navController: NavController) {

    Box(modifier = Modifier
        .padding(16.dp)
        .background(Color.White)
        .clip(RoundedCornerShape(8.dp))
        .fillMaxWidth()
    ) {

        Box(Modifier.fillMaxWidth().align(Alignment.TopEnd), contentAlignment = Alignment.TopEnd) {
            Image(
                painter = painterResource(id = R.drawable.top),
                contentDescription = "Top Design",
                modifier = Modifier
            )
        }

        Image(
            painter = painterResource(id = R.drawable.bottom),
            contentDescription = "Bottom Design",
            modifier = Modifier
                .fillMaxWidth(0.5F).align(

                    Alignment.BottomStart
                ),
            contentScale = ContentScale.FillWidth
        )

        Box(modifier = Modifier
            .fillMaxWidth()
            .zIndex(1F))
        {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {

                // Back button and Welcome text
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                {

                    IconButton(
                        onClick = { navController.popBackStack()  },
                        modifier = Modifier
                            .border(1.dp, Primary, RoundedCornerShape(50))
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Primary,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Text(
                        text = "Welcome!",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Medium,
                        color = Primary,
                        modifier = Modifier.padding(start = 16.dp)
                    )


                }
                Spacer(modifier = Modifier.height(32.dp))
                Column (Modifier.width(296.dp))
                {

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Discover Your Unique Learning Journey",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Select an activity",
                    color = Primary,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Activity Cards Grid
           Column(horizontalAlignment = Alignment.CenterHorizontally)
           {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ActivityCard(
                        title = "Start Assessment",
                        iconRes = R.drawable.start,
                        isActive = false
                    )
                    ActivityCard(
                        title = "Pattern Recognition",
                        iconRes = R.drawable.pattern,
                        isActive = true
                    )

                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ActivityCard(
                        title = "Reading Assessment",
                        iconRes = R.drawable.read,
                        isActive = false
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { /* Generate Assessment action */ },
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Light),
                    colors = ButtonColors(containerColor = Primary, disabledContainerColor = Primary, contentColor = Color.White, disabledContentColor = Color.White)
                )
                {
                    Text(text = "Generate Assessment")
                }
                    }
                    Spacer(modifier = Modifier.height(26.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Please attempt all for better feedback ",
                        color = WarningColor,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }

            }




        }
    }

}
@Composable
fun ActivityCard(
    title: String,
    iconRes: Int,
    isActive: Boolean
) {
    val appPrimary = Color(0xFFF8A800)
    val backgroundColor = if (isActive) appPrimary else Color.White
    val textColor = if (isActive) Color.White else Color(0xFF333333)

    Card(
        modifier = Modifier
            .size(140.dp, 180.dp)
            .border(
                width = 2.dp,
                color = appPrimary,
                shape = RoundedCornerShape(10.dp)
            ),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                modifier = Modifier.size(62.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                color = textColor,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }
    }
}