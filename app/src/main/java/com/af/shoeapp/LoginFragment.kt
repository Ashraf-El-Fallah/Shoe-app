package com.af.shoeapp

import android.content.Context
//import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_login, container, false)

        val mySharedPref=requireContext().getSharedPreferences("my_prefrences", Context.MODE_PRIVATE)
        val editor=mySharedPref.edit()




        val signInButton=view.findViewById<Button>(R.id.btnSignIn)
        val registerButton=view.findViewById<Button>(R.id.btnRegister)

        registerButton.setOnClickListener {

            val enteredEmail=view.findViewById<EditText>(R.id.etEmail).text.toString()
            val enteredPassword= view.findViewById<EditText>(R.id.etPassword).text.toString()

            editor.putString("email",enteredEmail)
            editor.putString("password",enteredPassword)
//            if(enteredEmail!= null && enteredPassword != null){
//                moveToNextScreen()
//            }
            editor.commit()

        }

        signInButton.setOnClickListener {

            val enteredEmail=view.findViewById<EditText>(R.id.etEmail).text.toString()
            val enteredPassword= view.findViewById<EditText>(R.id.etPassword).text.toString()

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