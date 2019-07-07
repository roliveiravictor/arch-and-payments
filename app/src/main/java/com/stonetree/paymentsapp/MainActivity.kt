package com.stonetree.paymentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.stonetree.paymentsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val container : ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        bindData(container)
    }

    private fun bindData(container: ActivityMainBinding) {
        container.presenter = MainPresenter(this)
        container.vm = MainViewModel()
    }
}
