package com.dnd_9th_3_android.gooding.feed.romanticFunction

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.dnd_9th_3_android.gooding.core.data.R
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.dnd_9th_3_android.gooding.data.contentLayout.camptonBold

@Composable
fun ProgressGraphic(
    tint : ColorFilter,
    progress : Float
) {
    // padding : 0~ 182
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center
    ){
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.size_50)))

        // 이동 이미지
        Box(
            modifier = Modifier
                .weight(1f)
        ){
            Box(
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.padding_36))
                    .height(dimensionResource(id = R.dimen.size_64))
            ){

                // top image
                Box(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.union_pro_h))
                        .width(dimensionResource(id = R.dimen.union_pro_w))
                        .align(Alignment.TopCenter)
                ){
                    // 말풍선 이미지
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.union_pro),
                        contentDescription = null,
                        colorFilter = tint
                    )

                    // 텍스트
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = dimensionResource(id = R.dimen.padding_6),
                                start = dimensionResource(id = R.dimen.padding_14)
                            )
                    ) {
                        Box(
                            modifier = Modifier
                                .wrapContentWidth()
                                .height(dimensionResource(id = R.dimen.padding_14))
                        ) {
                            Text(
                                text = progress.toInt().toString(),

                                fontSize = dimensionResource(id = R.dimen.text_12).value.sp,
                                fontFamily = camptonBold,
                                color = Color.White
                            )
                        }
                    }
                }


                // bottom image
                Box(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.bottom_pro_size))
                        .align(Alignment.BottomCenter)
                    ){
                        //empty
                        Image(
                            painterResource(id = R.drawable.circle_back_pro),
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(dimensionResource(id = R.dimen.circle_pro_size))
                        )
                        //circle
                        Image(
                            painter = painterResource(R.drawable.bottom_pro_image),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                        colorFilter = tint

                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.size_50)))
    }

}