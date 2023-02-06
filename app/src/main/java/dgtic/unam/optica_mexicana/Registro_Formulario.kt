package dgtic.unam.optica_mexicana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Registro_Formulario : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    //private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_formulario)
        val txtnombre_nuevo : TextView = findViewById(R.id.nuevoUsuario)
        val txtemail_nuevo : TextView = findViewById(R.id.nuevoemail)
        val txtpassword_nuevo:TextView = findViewById(R.id.nuevoPasword)
        val btnCrear:Button = findViewById(R.id.LgRegistrar)
        btnCrear.setOnClickListener {
            createAccount(txtemail_nuevo.text.toString(),txtpassword_nuevo.text.toString())
        }
        firebaseAuth = Firebase.auth
    }

    private fun createAccount(email:String,password:String){
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){
            task ->
            if(task.isSuccessful){
                Toast.makeText(baseContext, "Cuenta creada con exito!", Toast.LENGTH_SHORT).show()
                val intentOne = Intent(this,MainActivity::class.java)
                startActivity(intentOne)
            }
            else{
                Toast.makeText(baseContext, "No fue posible Crear una cuenta", Toast.LENGTH_SHORT).show()
            }
        }
    }
}