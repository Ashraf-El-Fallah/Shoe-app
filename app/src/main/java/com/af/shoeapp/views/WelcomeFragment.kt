package com.af.shoeapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.af.shoeapp.R
import com.af.shoeapp.databinding.FragmentInstructions1Binding
import com.af.shoeapp.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentWelcomeBinding.inflate(inflater,container,false)
        val view=binding.root

        val nextButton= binding.btnNext3
        nextButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_welcomeFragment_to_shoeListFragment)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}