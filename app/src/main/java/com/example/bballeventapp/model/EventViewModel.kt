package com.example.bballeventapp.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Event>>
    private val repository: EventRepository

    init{
        val eventDao = EventDatabase.getDatabase(application).eventDao()
        repository = EventRepository(eventDao)
        readAllData = repository.readAllData
    }

    fun addEvent(event: Event)
    {
        //Runs in the background
        viewModelScope.launch(Dispatchers.IO){
            repository.addEvent(event)
        }

    }
    fun updateEvent(event: Event)
    {
        viewModelScope.launch(Dispatchers.IO){
            repository.updateEvent(event)
        }
    }

    fun deleteEvent(event: Event)
    {
        viewModelScope.launch(Dispatchers.IO){
        repository.deleteEvent(event)}
    }

}
