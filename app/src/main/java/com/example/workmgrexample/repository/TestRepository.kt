package com.example.workmgrexample.repository

import android.util.Log
import kotlinx.coroutines.delay
import javax.inject.Inject

class TestRepository @Inject constructor(

) {
    suspend fun test(){
        delay(1000)
        Log.d("TestRepo", "Message from test repo")
    }
}