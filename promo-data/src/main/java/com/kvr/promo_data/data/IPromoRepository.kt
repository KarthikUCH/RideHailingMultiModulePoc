package com.kvr.promo_data.data

import com.kvr.promo_data.domain.Promo

interface IPromoRepository {

    fun getPromoList(): List<Promo>
}