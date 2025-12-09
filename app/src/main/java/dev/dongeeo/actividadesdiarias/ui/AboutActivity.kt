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
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import dev.dongeeo.actividadesdiarias.R

class AboutActivity : AppCompatActivity() {

    // Contrato para solicitar permisos de almacenamiento (ejemplo del documento del encargo)
    // Este permiso se solicita para demostrar el manejo de permisos sensibles usando el ciclo de vida
    private val requestStoragePermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            val message = if (granted) {
                "Permiso de almacenamiento concedido"
            } else {
                "Permiso de almacenamiento denegado"
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Configurar Toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        // Configurar saludo personalizado
        val userName = intent.getStringExtra(EXTRA_USER_NAME).orEmpty()
        findViewById<TextView>(R.id.tvAbout).text =
            if (userName.isNotBlank()) "Hola, $userName 👋" else "Hola 👋"

        // Botón de volver
        findViewById<MaterialButton>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // Solicitar permiso sensible (almacenamiento) para demostrar el manejo del ciclo de vida
        // Como se requiere en el encargo: "gestión de permisos sensibles (ej: almacenamiento)"
        requestStoragePermissionIfNeeded()
    }

    /**
     * Solicita permiso de almacenamiento (ejemplo mencionado en el documento del encargo).
     * Este permiso es sensible y requiere manejo del ciclo de vida.
     * 
     * El documento del encargo solicita: "gestión de permisos sensibles (ej: almacenamiento) 
     * utilizando el ciclo de vida a favor."
     */
    private fun requestStoragePermissionIfNeeded() {
        val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Manifest.permission.READ_MEDIA_IMAGES
        } else {
            Manifest.permission.READ_EXTERNAL_STORAGE
        }
        
        val granted = ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
        if (!granted) {
            requestStoragePermission.launch(permission)
        }
    }

    companion object {
        const val EXTRA_USER_NAME = "extra_user_name"
    }
}

