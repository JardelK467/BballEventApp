package com.example.bballeventapp.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bballeventapp.R
import com.example.bballeventapp.databinding.FragmentEntryBinding
import com.example.bballeventapp.model.Event
import com.example.bballeventapp.model.EventViewModel
import java.text.SimpleDateFormat
import java.util.*


class EntryFragment : Fragment() {

    private lateinit var mEventViewModel: EventViewModel

    private val binding by lazy {
        FragmentEntryBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mEventViewModel = ViewModelProvider(this).get(EventViewModel::class.java)

        binding.saveEventBtn.setOnClickListener{
            insertData()
        }
        return binding.root
        }

    private fun insertData() {

        val homeTeam = binding.homeTeamEntry.text.toString()
        val awayTeam = binding.awayTeamEntry.text.toString()
        val compLevel = binding.compLevel.text.toString()
        val date = binding.calendarEvent.date.toString()

        if(inputChecker(homeTeam,awayTeam,compLevel, date)){

        val event = Event(0,homeTeam, awayTeam, compLevel, date)
            mEventViewModel.addEvent(event)
            findNavController().navigate(
                R.id.action_EntryFragment_to_MainFragment)


        }
        }
    fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy.MM.dd")
        return format.format(date)
    }
    //Check if the fields are empty
    private fun inputChecker(homeTeam : String, awayTeam: String, compLevel : String, date : String): Boolean {
        return !(TextUtils.isEmpty(homeTeam) && TextUtils.isEmpty(awayTeam) && TextUtils.isEmpty(compLevel) && TextUtils.isEmpty(date) )
    }
    }





        // Inflate the layout for this fragment
