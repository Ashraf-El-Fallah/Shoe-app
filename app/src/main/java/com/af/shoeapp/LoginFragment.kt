package com.af.shoeapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController

class LoginFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mySharedPref=requireContext().getSharedPreferences("my_prefrences", Context.MODE_PRIVATE)
        val editor=mySharedPref.edit()

        val enteredEmail=R.id.etEmail.toString()
        val enteredPassword=R.id.etPassword.toString()

        val view= inflater.inflate(R.layout.fragment_login, container, false)
        val signInButton=view.findViewById<Button>(R.id.btnSignIn)
        val registerButton=view.findViewById<Button>(R.id.btnRegister)

        registerButton.setOnClickListener {

            editor.putString("email",enteredEmail)
            editor.putString("password",enteredPassword)
            if(enteredEmail!= null && enteredPassword != null){
                moveToNextScreen()
            }
            editor.commit()

        }

        signInButton.setOnClickListener {

            val storedEmail=mySharedPref.getString("email","")
            val storedPassword=mySharedPref.getString("password","")

            if(storedEmail==enteredEmail && storedPassword==enteredPassword){
                moveToNextScreen()
            }else{
                Toast.makeText(requireContext(),"Password or email is wrong",Toast.LENGTH_SHORT).show()
            }

        }

        return view
    }

    fun moveToNextScreen()
    {
        view?.findNavController()
            ?.navigate(R.id.action_loginFragment_to_welcomeFragment)
    }

}