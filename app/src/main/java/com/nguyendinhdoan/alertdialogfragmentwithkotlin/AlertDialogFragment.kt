package com.nguyendinhdoan.alertdialogfragmentwithkotlin

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.widget.Toast

class AlertDialogFragment : DialogFragment() {

    companion object {
        private const val TITLE_KEY = "TITLE_KEY"

        fun newInstance(dialogTitle: String): AlertDialogFragment {
            val alertDialogFragment = AlertDialogFragment()
            val args = Bundle()
            args.putString(TITLE_KEY, dialogTitle)
            alertDialogFragment.arguments = args
            return alertDialogFragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val context = activity as Context
        val alertDialog = AlertDialog.Builder(context)

        // get dialog title from arguments and set for alert dialog
        val dialogTitle = arguments!!.getString(TITLE_KEY)
        alertDialog.setTitle(dialogTitle)

        // set the information display on alert dialog
        alertDialog.setMessage(context.getString(R.string.dialog_message))
        alertDialog.setCancelable(false)

        // set the event when user click button dialog
        alertDialog.setPositiveButton(
            context.getString(R.string.dialog_button_ok)
        ) { _, _ ->
            // if success...
            Toast.makeText(context, "ok button clicked", Toast.LENGTH_SHORT).show()
        }

        alertDialog.setNegativeButton(
            context.getString(R.string.dialog_button_cancel)
        ) { dialog, _ ->
            // close dialog and back to the parent activity
            dialog!!.dismiss()
        }

        return alertDialog.create()
    }
}