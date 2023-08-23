package com.dnd_9th_3_android.gooding.login.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.dnd_9th_3_android.gooding.core.data.R

@Composable
fun FinishScreen(
    navController: NavHostController,
) {
    Image(
        painter = painterResource(id = R.drawable.finish_ment),
        contentDescription = null,
        modifier = Modifier
            .padding(
                top = dimensionResource(id = R.dimen.padding_36),
                start = dimensionResource(id = R.dimen.padding_18)
            )
            .width(dimensionResource(id = R.dimen.size_278))
            .height(dimensionResource(id = R.dimen.size_54))
    )

    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_107_96)))


    Image(
        painter = painterResource(id = R.drawable.finish_image),
        contentDescription = null,
        modifier = Modifier
            .padding(
                start = dimensionResource(id = R.dimen.padding_38)
            )
            .width(dimensionResource(id = R.dimen.size_284_53))
            .height(dimensionResource(id = R.dimen.size_263_68))
    )

}