package com.stonetree.payments.listeners

import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.Purchase

interface PaymentsListener {

    fun onPurchased()

    fun onPurchaseFailure()

}