package com.example.dogapiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dogapiapp.ui.MarsApp
import com.example.dogapiapp.ui.theme.DogApiAppTheme

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogApiAppTheme {
                //Initial App without Model
                MarsApp()
            }
        }
    }
}