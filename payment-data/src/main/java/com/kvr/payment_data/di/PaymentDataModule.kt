package com.kvr.payment_data.di

import com.kvr.payment_data.data.IPaymentRepository
import com.kvr.payment_data.data.PaymentRepository
import org.koin.dsl.module

val paymentDataModule = module {
    single<IPaymentRepository> { PaymentRepository() }
}