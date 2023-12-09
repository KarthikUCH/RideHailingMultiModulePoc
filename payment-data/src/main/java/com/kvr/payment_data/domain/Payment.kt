package com.kvr.payment_data.domain

sealed class Payment(val type: String)

class Cash(): Payment("Cash")

class Nets(): Payment("Nets")

class CreditCard(): Payment("CreditCard")
