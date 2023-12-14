package com.kvr.promo_ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kvr.promo_data.PromoListener
import com.kvr.promo_data.PromoListenerHolder
import com.kvr.promo_data.data.IPromoRepository
import com.kvr.promo_data.domain.Promo
import com.kvr.promo_ui.ui.theme.RideHailingMultiModulePocTheme
import org.koin.android.ext.android.inject

class PromoActivity : ComponentActivity() {
    private val promoListener: PromoListener? = PromoListenerHolder.promoListener
    private val promoRepository: IPromoRepository by inject()

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
                        name = "Promo",
                        promos = promoRepository.getPromoList(),
                        onPromoSelected = this::onPromoSelected,
                        onPromoRemoved = this::onPromoRemoved
                    )
                }
            }
        }
    }

    private fun onPromoSelected(promo: Promo) {
        promoListener?.onPromoSelected(promo)
        displayToastMsg()
    }

    private fun onPromoRemoved() {
        promoListener?.onPromoRemoved()
        displayToastMsg()
    }

    private fun displayToastMsg() {
        Toast.makeText(this, "Check log to find the update in Booking Manager", Toast.LENGTH_LONG)
            .show()
    }

    override fun onDestroy() {
        super.onDestroy()
        PromoListenerHolder.clearListener()
    }
}

@Composable
fun Greeting(
    name: String,
    promos: List<Promo>,
    modifier: Modifier = Modifier,
    onPromoSelected: (Promo) -> Unit,
    onPromoRemoved: () -> Unit
) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        Button(onClick = { onPromoSelected(promos[0]) }) {
            Text(
                text = "Promo: ${promos[0].code}",
                modifier = modifier
            )
        }

        Button(onClick = { onPromoSelected(promos[1]) }) {
            Text(
                text = "Promo: ${promos[1].code}",
                modifier = modifier
            )
        }

        Button(onClick = { onPromoSelected(promos[2]) }) {
            Text(
                text = "Promo: ${promos[2].code}",
                modifier = modifier
            )
        }

        Spacer(modifier = modifier.padding(vertical = 20.dp))

        Button(onClick = { onPromoRemoved() }) {
            Text(
                text = "Remove Selected Promo",
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RideHailingMultiModulePocTheme {
        Greeting(name = "Android", emptyList(), onPromoSelected = {}, onPromoRemoved = {})
    }
}