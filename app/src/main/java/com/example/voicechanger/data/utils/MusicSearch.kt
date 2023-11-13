package com.example.voicechanger.data.utils

import android.content.ContentResolver
import android.content.Context
import android.provider.MediaStore
import com.example.voicechanger.data.utils.models.MusicModel

class MusicSearch {
    companion object {
        fun getMusicFiles(context: Context): List<MusicModel> {
            val musicFiles = mutableListOf<MusicModel>()

            val contentResolver: ContentResolver = context.contentResolver
            val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
            val projection = arrayOf(
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION
            )

            val selection = "${MediaStore.Audio.Media.DATA} LIKE ? AND ${MediaStore.Audio.Media.IS_MUSIC} != 0"
            val selectionArgs = arrayOf("%.mp3")
            val sortOrder = "${MediaStore.Audio.Media.DISPLAY_NAME} ASC"

            val cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)

            cursor?.use {
                val idColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
                val nameColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)
                val titleColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
                val dataColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)
                val durationColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)

                while (it.moveToNext()) {
                    val id = it.getLong(idColumn)
                    val name = it.getString(nameColumn)
                    val title = it.getString(titleColumn)
                    val data = it.getString(dataColumn)
                    val duration = it.getLong(durationColumn).toString()
                    musicFiles.add(
                        MusicModel(
                            id.toString(),
                            name,
                            title,
                            data,
                            duration
                        )
                    )
                }
            }

            return musicFiles
        }
    }
}