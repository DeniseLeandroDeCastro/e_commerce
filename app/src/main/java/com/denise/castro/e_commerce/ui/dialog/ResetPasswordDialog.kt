package com.denise.castro.e_commerce.ui.dialog

import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.denise.castro.e_commerce.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

fun Fragment.setupBottomSheetDialog(
    onSendClick: (String) -> Unit
) {

    val dialog = BottomSheetDialog(requireContext(), R.style.DialogStyle)
    val view = layoutInflater.inflate(R.layout.reset_password_dialog, null)
    dialog.setContentView(view)
    dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
    dialog.show()

    val editEmail = view.findViewById<EditText>(R.id.editResetPassword)
    val buttonCancel = view.findViewById<Button>(R.id.buttonCancelResetPassword)
    val buttonSend = view.findViewById<Button>(R.id.buttonSendResetPassword)

    buttonSend.setOnClickListener {
        val email = editEmail.text.toString().trim()
        onSendClick(email)
        dialog.dismiss()
    }

    buttonCancel.setOnClickListener {
        dialog.dismiss()
    }
}