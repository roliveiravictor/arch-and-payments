package com.stonetree.payments.handlers

import com.stonetree.payments.listeners.PaymentsListener

class Payments {

    companion object {
        fun loadProduct(callback : PaymentsListener) {
            callback.onPurchased()
        }
    }

}