package com.example.bballeventapp.model

import androidx.lifecycle.LiveData

class EventRepository(private val eventDao: EventDao) {

    val readAllData : LiveData<List<Event>> = eventDao.readAllData()

    fun addEvent(event: Event){
        eventDao.addEvent(event)
    }
    fun updateEvent(event: Event){
        eventDao.updateEvent(event)
    }
    fun deleteEvent(event: Event){

        eventDao.deleteEvent(event)
    }
}