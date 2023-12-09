package com.kvr.payment_data

import com.kvr.payment_data.domain.Payment

interface PaymentListener {
    fun onPaymentSelected(payment: Payment)
}