package dgtic.unam.optica_mexicana

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class Formulario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)


        val backBtn:ImageView = findViewById(R.id.backHome)
        backBtn.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            with(builder) {
                setTitle("Home")
                setMessage("Si sale del formulario se perdera la información")
                setPositiveButton("OK", null)
                setNegativeButton("CANCEL", null)
                builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(baseContext, "Regresando al home", Toast.LENGTH_SHORT).show()
                    Intent_dialog()
                     })

                setIcon(resources.getDrawable(android.R.drawable.ic_menu_revert, theme))
            }
            val alertDialog = builder.create()
            alertDialog.show()

            val button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)




        }
    }

    private fun Intent_dialog() {
        val intentOne = Intent(this,Home::class.java)
        startActivity(intentOne)
    }
}