package com.example.display1000int

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList

class NumberViewModel : ViewModel() {

    private var numbers = MutableLiveData<ArrayList<NumberModel>>()
    private val numberList = ArrayList<NumberModel>()
    private val random = Random()

    init {
        populateNumbers(1000)
        numbers.value = numberList
    }

    fun getNumbers(): LiveData<ArrayList<NumberModel>> {
        return numbers
    }

    private fun populateNumbers(amount: Int) {
        for (i in 0 until amount) {
            numberList.add(NumberModel(random.nextInt(10000)))
        }
    }

}
