package dgtic.unam.optica_mexicana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val botonIngresar = findViewById<Button>(R.id.btnIngresar)
        botonIngresar.setOnClickListener{
            val intentOne = Intent(this,MainActivity::class.java)
            startActivity(intentOne)
        }
    }
}