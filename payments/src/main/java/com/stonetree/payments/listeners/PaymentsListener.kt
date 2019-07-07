package com.stonetree.payments.listeners

interface PaymentsListener {

    fun onPurchased()

    fun onPurchaseFailure()

}