package com.example.bballeventapp.ui

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.content.PackageManagerCompat.LOG_TAG
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bballeventapp.R
import com.example.bballeventapp.databinding.FragmentDetailsBinding
import com.example.bballeventapp.databinding.FragmentEntryBinding
import com.example.bballeventapp.model.Event
import com.example.bballeventapp.model.EventViewModel
import com.example.bballeventapp.ui.EntryFragment
import java.text.SimpleDateFormat
import java.util.*


class DetailFragment : Fragment() {


    private lateinit var mEventViewModel: EventViewModel
    private val args by navArgs<DetailFragmentArgs>()

    private val binding by lazy {
        FragmentDetailsBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        mEventViewModel = ViewModelProvider(this).get(EventViewModel::class.java)

        binding.homeTeamUpdate.setText(args.currentEvent.homeTeam)
        binding.awayTeamUpdate.setText(args.currentEvent.awayTeam)
        binding.compLevelUpdate.setText(args.currentEvent.levelOfComp)
        binding.calendarEventUpdate.date = args.currentEvent.date.toLong()

        binding.updateEventBtn.setOnClickListener{

            updateEvent()
        }

        return binding.root
    }

    private fun updateEvent(){
        val homeTeam = binding.homeTeamUpdate.text.toString()
        val awayTeam = binding.awayTeamUpdate.text.toString()
        val compLevel = binding.compLevelUpdate.text.toString()
        val date = binding.calendarEventUpdate.date.toString()

        if(inputChecker(homeTeam, awayTeam, compLevel, date)){

            val update = Event(args.currentEvent.id, homeTeam, awayTeam, compLevel,date)
            mEventViewModel.updateEvent(update)

            findNavController().navigate(R.id.action_DetailFragment_to_MainFragment)
        }

    }
    //Check if the fields are empty
    private fun inputChecker(homeTeam : String, awayTeam: String, compLevel : String, date : String): Boolean {
        return !(TextUtils.isEmpty(homeTeam) && TextUtils.isEmpty(awayTeam) && TextUtils.isEmpty(compLevel) && TextUtils.isEmpty(date) )
    }
    private fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy.MM.dd")
        return format.format(date)
    }
}