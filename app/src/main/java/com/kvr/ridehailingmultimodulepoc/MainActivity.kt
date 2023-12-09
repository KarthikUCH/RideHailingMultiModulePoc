package com.kvr.ridehailingmultimodulepoc

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kvr.ridehailingmultimodulepoc.ui.theme.RideHailingMultiModulePocTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RideHailingMultiModulePocTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", onBookCarRide = this::openCarRideActivity)
                }
            }
        }
    }

    private fun openCarRideActivity() {
        val intent = Intent()
        intent.setClassName(
            "com.kvr.ridehailingmultimodulepoc",
            "com.kvr.taxi_ui.CarRideActivity"
        )
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, onBookCarRide: () -> Unit) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        Button(onClick = { onBookCarRide() }) {
            Text(
                text = "Book Car Ride",
                modifier = modifier
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RideHailingMultiModulePocTheme {
        Greeting("Android") {

        }
    }
}