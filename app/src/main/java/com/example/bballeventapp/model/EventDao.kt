package com.example.bballeventapp.model
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EventDao {

    //If user already exists, ignore it
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addEvent(event: Event)

//    @Delete
//    fun deleteEvent(event: Event)

    @Update
    fun updateEvent(event: Event)

    //Reads all the data within the table
    @Query("SELECT * FROM event_table ORDER BY date ASC")
    fun readAllData(): LiveData<List<Event>>

}