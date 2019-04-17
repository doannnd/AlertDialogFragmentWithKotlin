package com.nguyendinhdoan.alertdialogfragmentwithkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val ALERT_DIALOG_TAG = "ALERT_DIALOG_TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        show_dialog_button_text.setOnClickListener {
            val dialogTitle = getString(R.string.dialog_title)
            val alertDialogFragment = AlertDialogFragment.newInstance(dialogTitle)
            alertDialogFragment.show(supportFragmentManager, ALERT_DIALOG_TAG)
        }
    }
}
