package com.kvr.taxi_ui

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
import com.kvr.navigation.Navigator
import com.kvr.payment_data.PaymentListener
import com.kvr.payment_data.PaymentListenerHolder
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
                    Greeting(
                        "Car Ride",
                        onPaymentClick = this::openPaymentActivity,
                        onPromoClick = this::openPromoActivity
                    )
                }
            }
        }

        bookingManager.onDropOffCleared()
    }

    private fun openPaymentActivity() {
        PaymentListenerHolder.setListener(bookingManager as PaymentListener)
        Navigator.openPaymentActivity(this)
    }

    private fun openPromoActivity() {
        Navigator.openPromoActivity(this)
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    onPaymentClick: () -> Unit,
    onPromoClick: () -> Unit
) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        Button(onClick = { onPaymentClick() }) {
            Text(
                text = "Choose Payment",
                modifier = modifier
            )
        }

        Button(onClick = { onPromoClick() }) {
            Text(
                text = "Choose Promo",
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RideHailingMultiModulePocTheme {
        Greeting(name = "Android", onPaymentClick = {}, onPromoClick = {})
    }
}