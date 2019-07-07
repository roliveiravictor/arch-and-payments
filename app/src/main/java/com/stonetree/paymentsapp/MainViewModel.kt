package com.stonetree.paymentsapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val status: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

}