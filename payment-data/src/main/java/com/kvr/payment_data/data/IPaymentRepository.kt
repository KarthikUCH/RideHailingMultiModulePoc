package com.kvr.payment_data.data

import com.kvr.payment_data.domain.Payment

interface IPaymentRepository {

    fun updateDefaultPayment(payment: Payment)
    fun getDefaultPayment(): Payment
}