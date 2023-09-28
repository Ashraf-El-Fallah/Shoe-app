package com.af.shoeapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.af.shoeapp.R
import com.af.shoeapp.data.Shoe

class ShareViewModel: ViewModel() {

    var shoes:ArrayList<Shoe> = arrayListOf<Shoe>(
    Shoe("Black shoes", "Adidas", R.drawable.shoes_black, "30"),
    Shoe("Nike shoes", "Nike", R.drawable.nike_shoes, "20"))

    private val _shoe=MutableLiveData<Shoe>()
    val shoe:LiveData<Shoe>
        get()=_shoe

    fun setShoe(shoe: Shoe){
        _shoe.value = shoe
    }








}