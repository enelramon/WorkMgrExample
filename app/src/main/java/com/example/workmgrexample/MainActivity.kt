package com.example.workmgrexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkManager
import com.example.workmgrexample.ui.theme.WorkMgrExampleTheme
import com.example.workmgrexample.work.MyWorker
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorkMgrExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        onClick = {
                            doWork()
                        }
                    )
                }
            }
        }
    }

    private fun doWork(){
        val request = OneTimeWorkRequestBuilder<MyWorker>()
            .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(request)

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier,
             onClick:()->Unit
             ) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        OutlinedButton(onClick = { onClick() }) {
            Text(text = "Work")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WorkMgrExampleTheme {
        Greeting("Android"){}
    }
}