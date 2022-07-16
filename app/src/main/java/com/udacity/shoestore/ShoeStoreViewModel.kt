package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeStoreViewModel:ViewModel() {


    private var _list= MutableLiveData<MutableList<Shoe>>()
    val list:LiveData<MutableList<Shoe>>
    get() = _list


    fun add(shoe: Shoe){
        if(list.value.isNullOrEmpty()){
        _list.value= mutableListOf(shoe)
        Log.i("i","FIRSTTIME")}
        else {
            list.value!!.add(shoe)
            Log.i("i","SECONDTIME")}

    }
    }





