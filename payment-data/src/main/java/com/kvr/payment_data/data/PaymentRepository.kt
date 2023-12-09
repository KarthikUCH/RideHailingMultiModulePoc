package com.kvr.payment_data.data

import com.kvr.payment_data.domain.Cash
import com.kvr.payment_data.domain.Payment

class PaymentRepository : IPaymentRepository {

    private var defaultPayment: Payment = Cash()

    override fun updateDefaultPayment(payment: Payment) {
        defaultPayment = payment
    }

    override fun getDefaultPayment(): Payment {
        return defaultPayment
    }
}