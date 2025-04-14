package com.galal.seenapay.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.galal.seenapay.R

class HomeViewModel : ViewModel() {


    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    fun setText(text: String) {
        _text.value = text
    }
}