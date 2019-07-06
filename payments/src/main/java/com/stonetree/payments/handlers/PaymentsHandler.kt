package com.stonetree.payments.handlers

import android.content.Context
import android.util.Log
import com.android.billingclient.api.*
import com.stonetree.payments.errors.PaymentsError
import com.stonetree.payments.handlers.Payments.Companion.loadProduct
import com.stonetree.payments.listeners.PaymentsListener

class PaymentsHandler : PurchasesUpdatedListener {

    private lateinit var billingClient: BillingClient

    private lateinit var callback: PaymentsListener

    private val billingClientListener = object : BillingClientStateListener {
        override fun onBillingSetupFinished(billingResult: BillingResult?) {
            when(billingResult?.responseCode) {
                BillingClient.BillingResponseCode.OK -> loadProduct(callback)
            }
        }

        override fun onBillingServiceDisconnected() {
            Log.d(javaClass.name, PaymentsError.CONNECTION_FAILURE)
        }
    }

    fun init(context : Context, callback : PaymentsListener) {
        this.callback = callback

        billingClient = BillingClient.newBuilder(context)
            .setListener(this)
            .build()

        billingClient.startConnection(billingClientListener)
    }

    override fun onPurchasesUpdated(billingResult: BillingResult?, purchases: MutableList<Purchase>?) {

    }
}