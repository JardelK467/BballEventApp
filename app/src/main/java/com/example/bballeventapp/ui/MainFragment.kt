package com.example.bballeventapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bballeventapp.R
import com.example.bballeventapp.adapter.EventAdapter
import com.example.bballeventapp.databinding.FragmentMainBinding
import com.example.bballeventapp.model.Event
import com.example.bballeventapp.model.EventViewModel


class MainFragment : Fragment() {

    private lateinit var mEventViewModel: EventViewModel

    private val binding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    private val eventAdapter by lazy {
        EventAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding.todoRecycler.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = eventAdapter

        }

        mEventViewModel = ViewModelProvider(this)[EventViewModel::class.java]
        mEventViewModel.readAllData.observe(viewLifecycleOwner) { event ->
            eventAdapter.updateEventsList(event)

            binding.createEvent.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_entryFragment)
            }

        }
            return binding.root
    }
}


