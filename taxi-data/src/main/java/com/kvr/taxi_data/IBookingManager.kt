package com.kvr.taxi_data

import com.kvr.taxi_data.domain.Address

interface IBookingManager {

    fun onPickUpSelected(address: Address)

    fun onDropOffSelected(address: Address)

    fun onPickupCleared()

    fun onDropOffCleared()
}