package com.anandusreekumar.cmpe277_1

import android.app.RemoteInput
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.anandusreekumar.cmpe277_1.ui.theme.CMPE277_1Theme

@ExperimentalMaterial3Api
@ExperimentalUnitApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CMPE277_1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.weight(1f, true)
                        ) {
                            TextButton(
                                onClick = {
                                    val intent = Intent(applicationContext, Assignment1::class.java).apply {
                                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                    }
                                    applicationContext.startActivity(intent)
                                },
                                colors = ButtonDefaults.buttonColors()
                            ) {
                                Text("Assignment - 1")
                            }
                        }
                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.weight(1f, true)
                        ) {
                            TextButton(
                                onClick = {
                                    val intent = Intent(applicationContext, Assignment2::class.java).apply {
                                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                    }
                                    applicationContext.startActivity(intent)
                                },
                                colors = ButtonDefaults.buttonColors()
                            ) {
                                Text("Assignment - 2")
                            }
                        }
                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.weight(1f, true)
                        ) {
                            TextButton(
                                onClick = {
                                    val intent = Intent(applicationContext, Assignment3::class.java).apply {
                                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                    }
                                    applicationContext.startActivity(intent)
                                },
                                colors = ButtonDefaults.buttonColors()
                            ) {
                                Text("Assignment - 3")
                            }
                        }
                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.weight(1f, true)
                        ) {
                            TextButton(
                                onClick = {
                                    val intent = Intent(applicationContext, Assignment5::class.java).apply {
                                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                    }
                                    applicationContext.startActivity(intent)
                                },
                                colors = ButtonDefaults.buttonColors()
                            ) {
                                Text("Assignment - 5")
                            }
                        }
                    }
                }
            }
        }
    }
}
