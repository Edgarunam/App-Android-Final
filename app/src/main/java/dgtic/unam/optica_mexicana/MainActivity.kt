package dgtic.unam.optica_mexicana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIngresar:Button = findViewById(R.id.LgIngresar)
        val txtemail:EditText = findViewById(R.id.correlg)
        val txtpasswd:EditText = findViewById(R.id.passwordlg)
        val btnRecuperar:TextView = findViewById(R.id.btnRecuperar)
        firebaseAuth=Firebase.auth
        btnIngresar.setOnClickListener{
            signIn(txtemail.text.toString(),txtpasswd.text.toString())
        }
        btnRecuperar.setOnClickListener {
            Toast.makeText(baseContext,"Se ha enviado la contraseña a su correo", Toast.LENGTH_SHORT).show()
        }
    }
    private fun signIn(email:String,password: String){
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){
            task->
            if(task.isSuccessful){
                val user = firebaseAuth.currentUser
                Toast.makeText(baseContext,"Bienvenido", Toast.LENGTH_SHORT).show()
                val intentOne = Intent(this,Home::class.java)
                startActivity(intentOne)
            }
            else{
                Toast.makeText(baseContext,"Email o Contraseña no son correctas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}