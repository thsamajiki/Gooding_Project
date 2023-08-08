package com.dnd_9th_3_android.gooding.data

import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import com.dnd_9th_3_android.gooding.data.model.GalleryImageData
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GalleryLocalDataSourceImpl @Inject constructor(
    @ApplicationContext context: Context
): GalleryLocalDataSource {

    private val resolver: ContentResolver? = context.contentResolver

    override suspend fun getAllImages(
        page: Int
    ): List<GalleryImageData> {
        val galleryImageList = mutableListOf<GalleryImageData>()
        // 외장 메모리에 있는 URI를 받도록 함
        val externalContentUri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        // 커서에 가져올 정보에 대해서 지정한다.
        val cursor: Cursor?

        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.TITLE,
            MediaStore.Images.Media.DISPLAY_NAME, // 이름
            MediaStore.Images.Media.MIME_TYPE,
            MediaStore.Images.Media.DATE_TAKEN,
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
            MediaStore.Images.Media.SIZE, // 크기
            MediaStore.Images.Media.WIDTH,
            MediaStore.Images.Media.HEIGHT,
        )

        val selection: String? = null
        val selectionArgs: Array<String>? = null

        cursor = resolver?.query(
            externalContentUri,
            projection,
            selection,
            selectionArgs,
            "${MediaStore.Images.ImageColumns.DATE_ADDED} DESC"
        )

        while (cursor?.moveToNext() == true) {
            galleryImageList.add(
                GalleryImageData(
                    uri = ContentUris.withAppendedId(
                        externalContentUri,
                        cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID))
                    ),
                    name = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.TITLE)),
                    fullName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)),
                    mimeType = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.MIME_TYPE)),
                    addedDate = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_TAKEN)),
                    folder = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME)),
                    size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE)),
                    width = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.WIDTH)),
                    height = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.HEIGHT)),
                )
            )

            cursor.close()
        }

        Log.d("TAG", "getAllImages: $galleryImageList")

        return galleryImageList
    }
}