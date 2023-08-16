package com.dnd_9th_3_android.gooding.my.itemFeed

import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dnd_9th_3_android.gooding.data.SampleFeedData
import com.dnd_9th_3_android.gooding.feature.my.R
import com.dnd_9th_3_android.gooding.model.feed.Feed

@Composable
fun ItemMainFeedScreen(
    feed : Feed
) {
    // is delete view?
    var showDeleteView by remember {
        mutableStateOf(false)
    }
    // 수정 필요
//    if (showDeleteView) {
//        DeleteFeedBottomSheet(
//            0,
//            onDelete = {
//                       // delete feed/ //
//            },
//            onClose = {
//                showDeleteView = false
//            },
//        )
//
//    }

    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                top = dimensionResource(id = R.dimen.padding_12),
                bottom = dimensionResource(id = R.dimen.padding_12)
            )
    ) {
        // left image
        LeftBarLayout(0)

        // feed main
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            TopInfoLayout(timeData = feed.uploadTime, onDelete = {
                // delete feed
                showDeleteView = true
            })
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_15)))
            CenterFeedLayout(location = feed.location, imageList = feed.urlList)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_12)))
            BottomFeedLayout(
                feed.subject, feed.content,
                onMoreInfo = {
                    // go more info
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewItemFeed(){
    ItemMainFeedScreen(SampleFeedData.sampleFeedList[0])
}