package com.demo.foodapp

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.MotionEvent
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.szagurskii.patternedtextwatcher.PatternedTextWatcher
import java.util.*


class PaymentScreen : AppCompatActivity() {

    lateinit var scanCard: AppCompatImageView
    lateinit var tIlEdtDate: TextInputLayout
    lateinit var tieEdtDate: TextInputEditText
    lateinit var edt_card_new: TextInputEditText

    lateinit var edtCvvText: TextInputEditText
    var isPasswordVisible = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        scanCard = findViewById<AppCompatImageView>(R.id.iv_batch)
        tIlEdtDate = findViewById<TextInputLayout>(R.id.edt_date)
        tieEdtDate = findViewById<TextInputEditText>(R.id.txt_date)
        edt_card_new = findViewById<TextInputEditText>(R.id.edt_card_new)

        edtCvvText = findViewById<TextInputEditText>(R.id.edt_cvv_text)
        edt_card_new.addTextChangedListener(PatternedTextWatcher("####-####-####-####"))

        toggle()
        scanCard.setOnClickListener {

            var intent = Intent(this,ScanCard::class.java)
            startActivity(intent)
        }

        tieEdtDate.setOnClickListener {
            val cal = Calendar.getInstance()
            val y = cal.get(Calendar.YEAR)
            val m = cal.get(Calendar.MONTH)
            val d = cal.get(Calendar.DAY_OF_MONTH)


            val datepickerdialog: DatePickerDialog = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener {  view, year, monthOfYear, dayOfMonth ->

                // Display Selected date in textbox
                tieEdtDate.setText("$dayOfMonth-$m-$year")
            }, y, m, d)
            val dp: DatePicker = datepickerdialog.datePicker
            dp.minDate = cal.timeInMillis;//get the current day

            datepickerdialog.show()

        }



    }

    fun toggle() {
        edtCvvText.setOnTouchListener { v, event ->
            val DRAWABLE_LEFT = 0
            val DRAWABLE_TOP = 1
            val DRAWABLE_RIGHT = 2
            val DRAWABLE_BOTTOM = 3
            if (event.getAction() === MotionEvent.ACTION_UP) {
                if (event.getRawX() >=  edtCvvText.getRight() -  edtCvvText.compoundDrawables[DRAWABLE_RIGHT].getBounds().width()) {
                    // your action here
                    if (isPasswordVisible) {
                        edtCvvText.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(baseContext, R.drawable.ic_eye), null)
                        edtCvvText.setInputType((InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD))
                        //   mBinding.edtPassword.setTypeface(ResourcesCompat.getFont(getContext(), R.font.segoe_print_bold))
                        isPasswordVisible = false
                    } else {
                        edtCvvText.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(baseContext, R.drawable.ic_eye_show), null)
                        edtCvvText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                        //  mBinding.edtPassword.setTypeface(ResourcesCompat.getFont(getContext(), R.font.segoe_print_bold))
                        isPasswordVisible = true
                    }
                }
            }
            false
        }
    }
}