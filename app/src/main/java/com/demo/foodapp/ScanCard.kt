package com.demo.foodapp

import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.card.MaterialCardView

class ScanCard:AppCompatActivity() {

    lateinit var scanCard: AppCompatImageButton
    lateinit var addManually: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_card)

        scanCard = findViewById(R.id.iv_logo)
        addManually = findViewById(R.id.add_manually)

        scanCard.setOnClickListener {

            RoundedBottomSheetDialogFragment().apply {
                show(supportFragmentManager, RoundedBottomSheetDialogFragment.TAG)
            }

        }

        addManually.setOnClickListener {

            var intent = Intent(this,PaymentScreen::class.java)
            startActivity(intent)
        }
    }
}