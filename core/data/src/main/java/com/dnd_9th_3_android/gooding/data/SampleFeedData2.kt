package com.dnd_9th_3_android.gooding.data

import com.dnd_9th_3_android.gooding.model.feed.Feed
import com.dnd_9th_3_android.gooding.model.feed.FileData
import com.dnd_9th_3_android.gooding.model.feed.MyFeed

object SampleFeedData2 {
    val sampleThumb = listOf(
        "https://media.w3.org/2010/05/sintel/poster.png",
    )
    private fun sampleRandomImage(id:Int) : String = "https://picsum.photos/id/$id/360/685"

    val sampleFeedList = arrayListOf(
        MyFeed(
            0,
            "나의 첫 굳이데이 기록",
            "rem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the ",
            "2023-01-14T14:49:09.230Z",
            "",
            0.toDouble(),
            0.toDouble(),
            10,
            "true",
            sampleRandomImage(1),
            arrayListOf(
                FileData(
                    0,
                    sampleRandomImage(1),
                ),
                FileData(
                    0,
                    sampleRandomImage(2),
                ),
                FileData(
                    0,
                    sampleRandomImage(3),
                )
            ),
        ),
        MyFeed(
            0,
            "나의 첫 굳이데이 기록",
            "rem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the ",
            "2023-12-15T14:49:09.230Z",
            "",
            0.toDouble(),
            0.toDouble(),
            80,
            "true",
            sampleRandomImage(20),
            arrayListOf(
                FileData(
                    0,
                    sampleRandomImage(20),
                ),
                FileData(
                    0,
                    sampleRandomImage(15),
                ),
                FileData(
                    0,
                    sampleRandomImage(3),
                )
            ),
        ),
    )
}