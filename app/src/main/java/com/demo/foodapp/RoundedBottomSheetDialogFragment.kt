package com.demo.foodapp

 import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
 import com.google.android.material.bottomsheet.BottomSheetDialog
 import com.google.android.material.bottomsheet.BottomSheetDialogFragment


open class RoundedBottomSheetDialogFragment : BottomSheetDialogFragment() {


    companion object {

        const val TAG = "CustomBottomSheetDialogFragment"

    }

    //Bottom Sheet Callback
    private val mBottomSheetBehaviorCallback: BottomSheetCallback = object : BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss()
            }
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {}
    }

  /*  override fun setupDialog(dialog: Dialog, style: Int) {

        //Get the content View
        val contentView = View.inflate(context, R.layout.layout_scan_success, null)
        dialog.setContentView(contentView)

        //Set the coordinator layout behavior
        val params = (contentView.parent as View).layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior

        //Set callback
        if (behavior != null && behavior is BottomSheetBehavior<*>) {
            behavior.setBottomSheetCallback(mBottomSheetBehaviorCallback)
        }
    }*/





    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener {
            dialog.setOnShowListener {
                val bottomSheetDialog = it as BottomSheetDialog
             }
        }

        return dialog
    }
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.layout_scan_success, container, false)
}