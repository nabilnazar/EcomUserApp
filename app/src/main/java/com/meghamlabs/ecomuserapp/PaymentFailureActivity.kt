package com.meghamlabs.ecomuserapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.meghamlabs.ecomuserapp.databinding.ActivityResultBinding

class PaymentFailureActivity : AppCompatActivity(){

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility = View.GONE
        binding.failureTv.visibility = View.VISIBLE
        binding.successTv.visibility = View.GONE

        binding.failureTv.postDelayed({
            Toast.makeText(this, "transaction failed Going back to main menu", Toast.LENGTH_LONG).show()
            finish()
        }, 3000)
    }
}