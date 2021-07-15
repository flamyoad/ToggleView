package com.flamyoad.toggleview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val bookmarkStatus = MutableLiveData(false)
    fun bookmarkStatus(): LiveData<Boolean> = bookmarkStatus

    fun toggleBookmarkStatus() {
        val prev = bookmarkStatus.value ?: false
        bookmarkStatus.value = !prev
    }
}