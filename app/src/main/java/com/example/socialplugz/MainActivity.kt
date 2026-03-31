package com.example.socialplugz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.socialplugz.ui.theme.SocialPlugzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SocialPlugzTheme {


                var text by remember { mutableStateOf(value = "") }
                var results by remember { mutableStateOf(value = "") }
                Column() { //Declaring variables
                    Text("Social Plugz")
                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("Enter time of day") }
                    )

                    Row() { //Prompting user to enter time of day
                        Button(
                            onClick = {
                                results = when (text) {
                                    "Morning" -> "Send a Good Morning Text"
                                    "Mid Morning" -> "Reach out to a colleague"
                                    "Afternoon" -> "Share a funny meme"
                                    "Afternoon Snack Time" -> "Send a quick thinking of you message"
                                    "Evening" -> "Call a friend or relative for a 5-minute catch-up"
                                    "Mid-Night" -> "Leave a thoughtful comment on a friend's post"
                                    else -> "Please check your spelling and try again!, Enter time of day eg, Morning"
                                }
                            }
                        )


                        {
                            Text("Suggest")
                        }
                        Button(
                            onClick = {
                                text = ""
                                results = ""
                            }
                        ) {
                            Text("Reset")

                        }

                    }
                    Text(results)
                }
            }
        }
    }
}