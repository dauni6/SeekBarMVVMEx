package com.dontsu.seekbarmvvmex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel: ViewModel() {
    val progress = MutableLiveData<Int>()
}