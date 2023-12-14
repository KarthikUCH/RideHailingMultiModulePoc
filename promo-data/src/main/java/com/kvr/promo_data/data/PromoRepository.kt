package com.kvr.promo_data.data

import com.kvr.promo_data.domain.Promo

class PromoRepository: IPromoRepository {
    override fun getPromoList(): List<Promo> {
        return listOf(
            Promo("Promo A", "RIDE 20", "RIDE 20 Description"),
            Promo("Promo B", "RIDE 10", "RIDE 10 Description"),
            Promo("Promo C", "GET 30", "GET 30 Description"))
    }
}