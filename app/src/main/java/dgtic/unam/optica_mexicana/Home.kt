package dgtic.unam.optica_mexicana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val btnexamen:Button = findViewById(R.id.btnExamen)
        btnexamen.setOnClickListener {
            Toast.makeText(baseContext, "Ingresando al formulario", Toast.LENGTH_SHORT).show()
            val intentOne = Intent(this,Formulario::class.java)
            startActivity(intentOne)
        }
    }
}