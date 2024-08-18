package com.example.workmgrexample.work

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.workmgrexample.repository.TestRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class MyWorker @AssistedInject constructor(
   private val testRepository: TestRepository,
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        Log.d("Worker", "Worker worked")
        try {
            testRepository.test()
        } catch (e: Exception) {

        }
        return Result.success()
    }
}