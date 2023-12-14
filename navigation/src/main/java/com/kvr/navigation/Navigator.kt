package com.kvr.navigation

import android.content.Context
import android.content.Intent

object Navigator {

    fun openPaymentActivity(context: Context) {
        val intent = Intent()
        intent.setClassName(
            "com.kvr.ridehailingmultimodulepoc",
            "com.kvr.payment_ui.PaymentActivity"
        )
        context.startActivity(intent)
    }

    fun openPromoActivity(context: Context) {
        val intent = Intent()
        intent.setClassName(
            "com.kvr.ridehailingmultimodulepoc",
            "com.kvr.promo_ui.PromoActivity"
        )
        context.startActivity(intent)
    }
}