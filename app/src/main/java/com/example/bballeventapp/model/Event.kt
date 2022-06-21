package com.example.bballeventapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
@Entity(tableName = "event_table")
data class Event(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val homeTeam: String,
    val awayTeam: String,
    val levelOfComp: String,
    val date: String
) : Parcelable