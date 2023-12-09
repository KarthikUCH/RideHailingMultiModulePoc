package com.kvr.taxi_data.domain

data class Address(
    val reference: Long,
    val lat: Double,
    val long: Double,
    val addressStr: String
)
