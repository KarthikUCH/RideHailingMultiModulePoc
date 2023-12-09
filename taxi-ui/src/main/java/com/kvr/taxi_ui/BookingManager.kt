package com.kvr.taxi_ui

import com.kvr.payment_data.PaymentListener
import com.kvr.payment_data.data.IPaymentRepository
import com.kvr.payment_data.domain.Payment
import com.kvr.taxi_data.IBookingManager
import com.kvr.taxi_data.domain.Address

class BookingManager(private val paymentRepository: IPaymentRepository) : IBookingManager,
    PaymentListener {

    private var pickupAddress: Address? = null
    private var dropOffAddress: Address? = null
    private lateinit var selectedPayment: Payment

    init {
        getDefaultPayment()
    }

    override fun onPaymentSelected(payment: Payment) {
        println("Payment Selected ${payment.type}")
        selectedPayment = payment
    }

    override fun onPickUpSelected(address: Address) {
        pickupAddress = address
    }

    override fun onDropOffSelected(address: Address) {
        dropOffAddress = address
    }

    override fun onPickupCleared() {
        pickupAddress = null
    }

    override fun onDropOffCleared() {
        dropOffAddress = null
    }

    private fun getDefaultPayment() {
        selectedPayment = paymentRepository.getDefaultPayment()
    }
}