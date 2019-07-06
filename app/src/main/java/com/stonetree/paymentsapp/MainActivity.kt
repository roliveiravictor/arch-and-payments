package com.stonetree.paymentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stonetree.payments.Payments

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Payments.start(this)
    }
}
