package dgtic.unam.optica_mexicana

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Formulario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)


        val backBtn:ImageView = findViewById(R.id.backHome)
        val finalizarbtn:Button = findViewById(R.id.btnfinalizar)

        finalizarbtn.setOnClickListener {
            Toast.makeText(baseContext, "Pdf Generado y guardado en el dispositivo", Toast.LENGTH_SHORT).show()
        }
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