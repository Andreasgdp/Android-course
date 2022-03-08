package com.example.exercise1.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exercise1.R

class WhiteFragment : Fragment() {

    companion object {
        fun newInstance() = WhiteFragment()
    }

    private lateinit var viewModel: WhiteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.white_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WhiteViewModel::class.java)
        // TODO: Use the ViewModel
    }

}