package com.af.shoeapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.af.shoeapp.R

class Instructions2Fragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_instructions2, container, false)
        val nextButton=view.findViewById<Button>(R.id.btnNext2)

        nextButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_instructions2Fragment_to_loginFragment)
        }

        return view
    }


}