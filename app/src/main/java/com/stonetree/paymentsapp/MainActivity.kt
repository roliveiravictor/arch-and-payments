package com.stonetree.paymentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.stonetree.payments.Payments
import com.stonetree.payments.listeners.PaymentsListener
import com.stonetree.paymentsapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PaymentsListener {

    private lateinit var vm : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val container : ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        vm = ViewModelProviders.of(this).get(MainViewModel::class.java)

        bindData(container)
        bindObserver()
    }

    private fun bindData(container: ActivityMainBinding) {
        container.vm = MainViewModel()
        container.view = this@MainActivity
    }

    private fun bindObserver() {
        val purchase = Observer<String> {
            purchase.text = it
        }
        vm.status.observe(this, purchase)
    }

    override fun onPurchaseFailure() {
        vm.status.value = "Product not found"
    }

    override fun onPurchased() {
        vm.status.value = "Purchased"
    }

    fun onClick(view: View) {
        Payments.start(view.context, this)
    }
}
