package com.af.shoeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController


class Instructions1Fragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_instructions1, container, false)
        val nextButton=view.findViewById<Button>(R.id.btnNext1)

        nextButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_instructions1Fragment_to_instructions2Fragment)
        }

        return view
    }


}