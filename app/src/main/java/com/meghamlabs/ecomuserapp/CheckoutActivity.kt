package com.meghamlabs.ecomuserapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.meghamlabs.ecomuserapp.databinding.CheckoutPageBinding
import dev.shreyaspatil.easyupipayment.EasyUpiPayment
import dev.shreyaspatil.easyupipayment.listener.PaymentStatusListener
import dev.shreyaspatil.easyupipayment.model.Payment
import dev.shreyaspatil.easyupipayment.model.TransactionDetails



class CheckoutActivity : AppCompatActivity() {

    private lateinit var binding: CheckoutPageBinding
    private lateinit var easyUpiPayment: EasyUpiPayment
    private val UPI_PAYMENT = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CheckoutPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val price = intent.getStringExtra("price")
        binding.priceCheckOut.text = price
        binding.nameCheckOut.text = intent.getStringExtra("name")
        intent.getStringExtra("image")?.let { imageUrl ->
            Glide.with(this)
                .load(imageUrl)
                .into(binding.imageCheckOut)

        }

        binding.cancelButton.setOnClickListener {
            finish()
        }

        binding.confirmButton.setOnClickListener {

            upiPayment(price)
           // payUsingUpi()
        }
    }

    private fun upiPayment(price: String?) {

        easyUpiPayment = EasyUpiPayment(
            this, Payment(
                "INR",
                "rasoolameen619@okicici",
                "Nabil",
                "123",
                "100",
                "100",
                "testing",
                "2",
                null
            )
        )
        easyUpiPayment.startPayment()

        easyUpiPayment.setPaymentStatusListener(object : PaymentStatusListener {
            override fun onTransactionCancelled() {
                //  Toast.makeText(this@CheckoutActivity, "Transaction cancelled by you", Toast.LENGTH_LONG).show()
                val intent = Intent(this@CheckoutActivity, PaymentFailureActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onTransactionCompleted(transactionDetails: TransactionDetails) {
                // Payment was successful, launch new activity for success
                val intent = Intent(this@CheckoutActivity, PaymentSuccessActivity::class.java)
                startActivity(intent)
                finish()
            }

        })

    }


}

