package com.kvr.promo_data

object PromoListenerHolder {
    var promoListener: PromoListener? = null
        private set


    fun setListener(listener: PromoListener) {
        promoListener = listener
    }

    fun clearListener() {
        promoListener = null
    }
}