package com.kvr.taxi_ui

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
import com.kvr.taxi_data.IBookingManager
import com.kvr.taxi_ui.ui.theme.RideHailingMultiModulePocTheme
import org.koin.android.ext.android.inject

class CarRideActivity : ComponentActivity() {

    private val bookingManager: IBookingManager by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RideHailingMultiModulePocTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Car Ride", onPaymentClick = this::openPaymentActivity)
                }
            }
        }

        bookingManager.onDropOffCleared()
    }

    private fun openPaymentActivity() {
        val intent = Intent()
        intent.setClassName(
            "com.kvr.ridehailingmultimodulepoc",
            "com.kvr.payment_ui.PaymentActivity"
        )
        startActivity(intent)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, onPaymentClick: () -> Unit) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        Button(onClick = { onPaymentClick() }) {
            Text(
                text = "Open Payment",
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