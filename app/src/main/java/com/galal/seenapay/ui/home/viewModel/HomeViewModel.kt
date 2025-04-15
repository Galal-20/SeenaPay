package com.galal.seenapay.ui.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {


    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    fun setText(text: String) {
        _text.value = text
    }
}