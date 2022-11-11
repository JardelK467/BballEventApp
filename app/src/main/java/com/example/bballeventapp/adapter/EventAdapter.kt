package com.example.bballeventapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bballeventapp.databinding.TodoItemBinding
import com.example.bballeventapp.model.Event
import com.example.bballeventapp.ui.MainFragmentDirections
import java.text.SimpleDateFormat

class EventAdapter(private var eventsList: List<Event> = emptyList()) : RecyclerView.Adapter<EventViewHolder>() {

    //Add to events list
    fun updateEventsList(event: List<Event>) {
        this.eventsList = event
        notifyDataSetChanged()
    }

    fun deleteEvent(event: Event){
        this.eventsList
        notifyDataSetChanged()
    }

    //Create a Viewholder for Recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder =
        EventViewHolder(
            TodoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    //takes data from events list and sets to the corresponding view
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) =
        holder.bind(eventsList[position])

    override fun getItemCount(): Int = eventsList.size

}
    class EventViewHolder(private val binding: TodoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {
            binding.homeTeam.text = event.homeTeam
            binding.awayTeam.text = event.awayTeam
            binding.comp.text = event.levelOfComp
            binding.eventDate.text = event.date

            binding.todoLayout.setOnClickListener{
                val action = MainFragmentDirections.actionMainFragmentToDetailsFragment(event)
                findNavController(it).navigate(action)
            }
        }

    }
