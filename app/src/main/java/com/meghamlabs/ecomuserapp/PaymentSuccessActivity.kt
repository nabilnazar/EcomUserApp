package com.meghamlabs.ecomuserapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.meghamlabs.ecomuserapp.databinding.ActivityResultBinding
import com.meghamlabs.ecomuserapp.databinding.CheckoutPageBinding

class PaymentSuccessActivity : AppCompatActivity(){

     private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility = View.GONE
        binding.failureTv.visibility = View.GONE
        binding.successTv.visibility = View.VISIBLE

        binding.successTv.postDelayed({
            Toast.makeText(this, "transaction successfull Going back to main menu", Toast.LENGTH_LONG).show()
            finish()
        }, 3000)
    }
}
