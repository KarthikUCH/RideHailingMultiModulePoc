package com.kvr.taxi_ui.di

import com.kvr.taxi_data.IBookingManager
import com.kvr.taxi_ui.BookingManager
import org.koin.dsl.module


val taxiUiModule = module {

    single<IBookingManager> {
        BookingManager(get())
    }
}