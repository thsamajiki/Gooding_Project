package com.dnd_9th_3_android.gooding.data

import com.dnd_9th_3_android.gooding.model.Feed
import com.dnd_9th_3_android.gooding.model.UserInfo

object SampleFeedData {
    val sampleFeedList = listOf(
        Feed(
            "나의 첫 굳이데이 기록",
            "rem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the ",
            10,
            "광안리 해수욕장",
            listOf("https://www.visitbusan.net/uploadImgs/files/cntnts/20191229160530047_oen"),
            "5분 전",
            UserInfo(
                "jiyoung_5386",
                "https://www.visitbusan.net/uploadImgs/files/cntnts/20191229160530047_oen"
            )

        )
    )
}