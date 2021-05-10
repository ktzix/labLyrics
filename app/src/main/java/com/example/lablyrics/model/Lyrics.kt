package com.example.lablyrics.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


@Parcelize
@Entity(tableName = "lyrics", indices = [Index(value = ["artist", "title"], unique = true)])
data class Lyrics(
    var artist: String?,
    var title: String?,
    var text:  String?
): Parcelable{
    @PrimaryKey(autoGenerate = true) var id: Int = 0

}