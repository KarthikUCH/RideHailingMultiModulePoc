package com.kvr.ridehailingmultimodulepoc.di

import com.kvr.payment_data.PaymentListener
import com.kvr.taxi_data.IBookingManager
import org.koin.dsl.module

val appListenerModule = module {

    factory<PaymentListener> {
        val bookingManager: IBookingManager by inject()
        bookingManager as PaymentListener
    }
}