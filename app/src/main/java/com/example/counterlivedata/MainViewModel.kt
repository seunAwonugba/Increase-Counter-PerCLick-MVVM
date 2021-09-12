package com.example.counterlivedata

import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    var counter = 0

    fun increaseCounterInMainViewModel(){
        counter++
    }
}