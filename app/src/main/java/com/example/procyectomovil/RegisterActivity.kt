package com.example.procyectomovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.procyectomovil.databinding.ActivityRegistroBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        auth = Firebase.auth



            binding.btnRegistro.setOnClickListener{createRegister()}
        }



    private fun createRegister() {
    val name = binding.etUser.text.toString()
    val email = binding.etEmail.text.toString()
    val clave = binding.etClave.text.toString()



        auth.createUserWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful){
                    val user = auth.currentUser
                    refresh(user)
                } else {
                    Toast.makeText(baseContext,getString(R.string.msg_failure),Toast.LENGTH_LONG).show()
                    refresh(null)
                }
            }
    }

    private fun refresh(user: FirebaseUser?) {
       if (user!=null){
           val  intent = Intent(this,LoginActivity::class.java)
           startActivity(intent)
       }
    }
}