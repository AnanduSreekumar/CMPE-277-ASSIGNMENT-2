package com.anandusreekumar.cmpe277_1

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.anandusreekumar.cmpe277_1.ui.theme.CMPE277_1Theme

class Assignment2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CMPE277_1Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    WebLinkAndPhoneCallApp(applicationContext = applicationContext) {
                        finish()
                    }
                }
            }
        }
    }
}

@Composable
fun WebLinkAndPhoneCallApp(applicationContext: Context, onClose: () -> Unit) {
    val url = remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(10.dp)) {
        UserInputField("URL", url.value) { url.value = it }
        ActionButton("Launch", url.value, applicationContext, isWebLink = true)

        Spacer(modifier = Modifier.height(20.dp))
        Divider(thickness = 1.dp, color = Color.Gray)

        UserInputField("Phone", phoneNumber.value) { phoneNumber.value = it }
        ActionButton("Ring", phoneNumber.value, applicationContext)

        Spacer(modifier = Modifier.height(20.dp))
        Divider(thickness = 1.dp, color = Color.Gray)
        
        TextButton(onClick = onClose, colors = ButtonDefaults.buttonColors()) {
            Text("Close App")
        }
    }
}

@Composable
fun UserInputField(label: String, value: String, onValueChange: (String) -> Unit) {
    TextField(value = value, onValueChange = onValueChange, placeholder = { Text(text = label) })
}

@Composable
fun ActionButton(buttonText: String, value: String, context: Context, isWebLink: Boolean = false) {
    TextButton(onClick = {
        if (value.isEmpty()) {
            Toast.makeText(context, "$buttonText field cannot be empty!", Toast.LENGTH_LONG).show()
        } else {
            val action = if (isWebLink) Intent.ACTION_VIEW else Intent.ACTION_DIAL
            val data = if (isWebLink) Uri.parse(value) else Uri.parse("tel:$value")
            val intent = Intent(action, data).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                resolveActivity(context.packageManager)
            }
            context.startActivity(intent)
        }
    }) {
        Text(text = buttonText)
    }
}
