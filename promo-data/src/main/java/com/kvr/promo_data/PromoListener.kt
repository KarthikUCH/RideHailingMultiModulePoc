package com.kvr.promo_data

import com.kvr.promo_data.domain.Promo

interface PromoListener {
    fun onPromoSelected(promo: Promo)

    fun onPromoRemoved()
}