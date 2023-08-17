package com.dnd_9th_3_android.gooding.feed.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dnd_9th_3_android.gooding.feature.feed.R

@Composable
fun MidInfoLayer(
    location : String,
    subject : String,
    content : String,
) {

    // location
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(
            start=18.dp, end = 18.dp
        )
    ) {
        // location Info
        Row(
            modifier = Modifier
                .background(Color.Gray, RoundedCornerShape(8.dp))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_location_on_24), contentDescription =null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(text = location, color = Color.White, fontSize = 10.sp)
        }

        Divider(modifier = Modifier.weight(1f))

    }
    
    // subject
    Text(
        text = subject, color = Color.White,
        modifier = Modifier
            .width(300.dp)
            .padding(
                top = 10.dp,
                start = 18.dp,
                end = 18.dp
            )
    )

    // content
    Text(
        text = content, color = Color.White, maxLines = 2,
        modifier = Modifier
            .width(300.dp)
            .padding(
                top = 5.dp,
                start = 18.dp,
                end = 18.dp
            )
    )
}