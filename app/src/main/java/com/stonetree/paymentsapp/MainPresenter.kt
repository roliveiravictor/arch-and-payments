package com.stonetree.paymentsapp

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.stonetree.payments.Payments
import com.stonetree.payments.listeners.PaymentsListener
import kotlinx.android.synthetic.main.activity_main.*

class MainPresenter(activity: MainActivity) : PaymentsListener {

    private var model: MainViewModel = ViewModelProviders.of(activity).get(MainViewModel::class.java)

    init {
        val purchase = Observer<String> {
            activity.purchase.text = it
        }

        model.status.observe(activity, purchase)
    }

    override fun onPurchaseFailure() {
        model.status.value = "Failure"
    }

    override fun onPurchased() {
        model.status.value = "Purchased"
    }

    fun onClick(view: View) {
        Payments.start(view.context, this)
    }

}