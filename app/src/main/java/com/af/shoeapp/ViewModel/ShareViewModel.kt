package com.af.shoeapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.af.shoeapp.data.Shoe

class ShareViewModel: ViewModel() {

    //shoe detail...................

    //save
    private val _eventSaveShoeDetailPress= MutableLiveData(false)
    val eventSaveShoeDetailPress:LiveData<Boolean>
        get()=_eventSaveShoeDetailPress

    //cancel
    private val _eventCancelShoeDetailPress = MutableLiveData(false)
    val eventCancelShoeDetailPress: LiveData<Boolean>
        get() = _eventCancelShoeDetailPress


    private val _shoe=MutableLiveData<Shoe>()
    val shoe:LiveData<Shoe>
        get()=_shoe


    fun setShoe(shoe: Shoe){
        _shoe.value = shoe
    }








}