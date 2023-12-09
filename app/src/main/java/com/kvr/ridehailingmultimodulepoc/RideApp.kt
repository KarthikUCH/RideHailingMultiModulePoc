package com.kvr.ridehailingmultimodulepoc

import android.app.Application
import com.kvr.payment_data.di.paymentDataModule
import com.kvr.ridehailingmultimodulepoc.di.appListenerModule
import com.kvr.taxi_ui.di.taxiUiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RideApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RideApp)
            modules(
                listOf(
                    appListenerModule,
                    taxiUiModule,
                    paymentDataModule,
                )
            )
        }
    }
}