package com.kvr.promo_data.di

import com.kvr.promo_data.data.IPromoRepository
import com.kvr.promo_data.data.PromoRepository
import org.koin.dsl.module

val promoDataModule = module {
    single<IPromoRepository> { PromoRepository() }
}