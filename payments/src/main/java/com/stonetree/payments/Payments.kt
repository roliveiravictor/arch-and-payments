package com.stonetree.payments

import android.content.Context
import com.stonetree.payments.handlers.PaymentsHandler
import com.stonetree.payments.listeners.PaymentsListener

class Payments {

    companion object {
        fun start(context: Context, callback : PaymentsListener) {
            val paymentsHandler = PaymentsHandler()
            paymentsHandler.init(context, callback)
        }
    }

}