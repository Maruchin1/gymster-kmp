package com.maruchin.gymster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.koin.dsl.module

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val platformModule = module {
            factory { applicationContext }
        }
        setContent {
            App(platformModule)
        }
    }
}

@Preview
@Composable
private fun AppAndroidPreview() {
    App()
}
