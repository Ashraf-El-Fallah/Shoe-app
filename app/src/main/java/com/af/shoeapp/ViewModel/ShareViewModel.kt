package com.af.shoeapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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


    //company name
    private val _companyName=MutableLiveData<String>()
    val companyName:LiveData<String>
        get()=_companyName

    fun setCompanyName(name:String){
        _companyName.value=name
    }

    //shoe name
    private val _shoeName=MutableLiveData<String>()
    val shoeName:LiveData<String>
        get()=_shoeName

    fun setShoeName(name:String){
        _shoeName.value=name
    }

    //shoe size
    private val _shoeSize=MutableLiveData<String>("0")
    val shoeSize:LiveData<String>
        get()=_shoeSize

    fun setShoeSize(size:String){
        _shoeSize.value=size
    }








}