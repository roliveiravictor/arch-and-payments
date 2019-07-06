package com.stonetree.paymentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.stonetree.payments.Payments
import com.stonetree.payments.listeners.PaymentsListener

class MainActivity : AppCompatActivity(), PaymentsListener {

    override fun onPurchaseFailure() {

    }

    override fun onPurchased() {
        Log.d(javaClass.name, "Purchased")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Payments.start(this, this)
    }

    @BindingAdapter("app:hideIfZero")  // Recommended solution
    @JvmStatic fun hideIfZero(view: View, number: Int) {
        view.visibility = if (number == 0) View.GONE else View.VISIBLE
    }
}
