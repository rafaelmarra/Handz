package com.marrapps.handz

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    fun showErrorDialog(message: String, onRetry: () -> Unit) {
        AlertDialog.Builder(this)
            .setTitle("Erro")
            .setMessage(message)
            .setPositiveButton(
                "Tentar novamente"
            ) { dialog, _ ->
                dialog.dismiss()
            }.setOnDismissListener {
                onRetry()
            }
            .show()
    }
}
