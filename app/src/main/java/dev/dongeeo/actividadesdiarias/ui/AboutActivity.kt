package dev.dongeeo.actividadesdiarias.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import dev.dongeeo.actividadesdiarias.R

class AboutActivity : AppCompatActivity() {

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            val message = if (granted) {
                "Permiso concedido"
            } else {
                "Permiso denegado"
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val userName = intent.getStringExtra(EXTRA_USER_NAME).orEmpty()
        findViewById<TextView>(R.id.tvAbout).text =
            if (userName.isNotBlank()) "Hola, $userName 👋" else "Hola 👋"

        requestNotificationPermissionIfNeeded()
    }

    private fun requestNotificationPermissionIfNeeded() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val permission = Manifest.permission.POST_NOTIFICATIONS
            val granted = ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
            if (!granted) {
                requestPermission.launch(permission)
            }
        }
    }

    companion object {
        const val EXTRA_USER_NAME = "extra_user_name"
    }
}

