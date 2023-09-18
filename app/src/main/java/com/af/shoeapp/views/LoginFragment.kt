package com.af.shoeapp.views

//import android.os.Build.VERSION_CODES.R
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.af.shoeapp.R
import com.af.shoeapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding?=null
    private val binding get()=_binding!!

    private val mySharedPref=requireContext().getSharedPreferences("my_prefrences", Context.MODE_PRIVATE)
    private val editor=mySharedPref.edit()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentLoginBinding.inflate(inflater,container,false)
        val view=binding.root

//        if (isAdded) {
//            // Access context-related operations here
//            activity?.applicationContext
//            context?.resources
//        }

        setOnClicks()

        return view
    }


    private fun setOnClicks(){

        binding.btnRegister.setOnClickListener {
            saveSharedPreferenceData()
        }

        binding.btnSignIn.setOnClickListener {
            getSharedPreferenceData()
        }

    }

    private fun getSharedPreferenceData(){
        //signIn
        val enteredEmail=binding.etEmail.text.toString()
        val enteredPassword= binding.etPassword.text.toString()

        val storedEmail=mySharedPref.getString("email","")
        val storedPassword=mySharedPref.getString("password","")

        if(storedEmail==enteredEmail && storedPassword==enteredPassword){
            moveToNextScreen()
        }else{
            Toast.makeText(requireContext(),"Password or email is wrong",Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveSharedPreferenceData(){

        //register
        val enteredEmail=binding.etEmail.text.toString()
        val enteredPassword= binding.etPassword.text.toString()

        editor.putString("email",enteredEmail)
        editor.putString("password",enteredPassword)
//            if(enteredEmail!= null && enteredPassword != null){
//                moveToNextScreen()
//            }
        editor.commit()
    }

    fun moveToNextScreen()
    {
        view?.findNavController()
            ?.navigate(R.id.action_loginFragment_to_welcomeFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }



}