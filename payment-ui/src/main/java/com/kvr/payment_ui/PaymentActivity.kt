package com.kvr.payment_ui

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
import com.kvr.payment_data.PaymentListener
import com.kvr.payment_data.domain.Cash
import com.kvr.payment_data.domain.CreditCard
import com.kvr.payment_data.domain.Nets
import com.kvr.payment_data.domain.Payment
import com.kvr.payment_ui.ui.theme.RideHailingMultiModulePocTheme
import org.koin.android.ext.android.inject

class PaymentActivity : ComponentActivity() {
    private val paymentListener: PaymentListener by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RideHailingMultiModulePocTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Payment", onPaymentSelected = this::onPaymentSelected)
                }
            }
        }
    }

    private fun onPaymentSelected(payment: Payment) {
        paymentListener.onPaymentSelected(payment)
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    onPaymentSelected: (payment: Payment) -> Unit
) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        Button(onClick = { onPaymentSelected(Cash()) }) {
            Text(
                text = "Select Cash",
                modifier = modifier
            )
        }

        Button(onClick = { onPaymentSelected(Nets()) }) {
            Text(
                text = "Select Nets",
                modifier = modifier
            )
        }

        Button(onClick = { onPaymentSelected(CreditCard()) }) {
            Text(
                text = "Select Credit Card",
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