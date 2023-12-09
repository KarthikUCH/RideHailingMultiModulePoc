package com.kvr.payment_data

object PaymentListenerHolder {
    var paymentListener: PaymentListener? = null
        private set


    fun setListener(listener: PaymentListener) {
        paymentListener = listener
    }

    fun clearListener() {
        paymentListener = null
    }
}