package com.dnd_9th_3_android.gooding.data

import com.dnd_9th_3_android.gooding.model.feed.Feed

object SampleFeedData {
    val sampleThumb = listOf(
        "https://media.w3.org/2010/05/sintel/poster.png",
    )
    val sampleFeedList = listOf(
        Feed(
            "나의 첫 굳이데이 기록",
            "rem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the ",
            10,
            "광안리 해수욕장",
            listOf(
                "https://media.w3.org/2010/05/sintel/trailer.mp4",
                "https://www.visitbusan.net/uploadImgs/files/cntnts/20191229160530047_oen",
                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
            ),
            "2023-01-14T14:49:09.230Z",
            SampleUserData.sampleUserData[0]

        ),
        Feed(
            "나의 두번째 굳이데이 기록",
            "rem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the ",
            30,
            "광안리 해수욕장",
            listOf(
                "https://www.visitbusan.net/uploadImgs/files/cntnts/20191229160529389_ttiel",
                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "https://www.visitbusan.net/uploadImgs/files/cntnts/20191229160529389_ttiel",
                "https://www.visitbusan.net/uploadImgs/files/cntnts/20191229160529389_ttiel",
            ),
            "2023-12-15T14:49:09.230Z",
            SampleUserData.sampleUserData[1]

        )
    )
}