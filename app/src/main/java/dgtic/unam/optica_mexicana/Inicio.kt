package dgtic.unam.optica_mexicana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val botonIngresar = findViewById<Button>(R.id.btnIngresar)
        val btnRegistrar:TextView = findViewById(R.id.txtregistrar)
        botonIngresar.setOnClickListener{
            val intentOne = Intent(this,MainActivity::class.java)
            startActivity(intentOne)
        }
        btnRegistrar.setOnClickListener {
            Toast.makeText(baseContext,"Bienvenido! Ingrese los datos solicitados", Toast.LENGTH_SHORT).show()
            val intentOne = Intent(this,Registro_Formulario::class.java)
            startActivity(intentOne)
        }
    }
}