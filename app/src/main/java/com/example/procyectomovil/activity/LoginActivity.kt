package com.example.procyectomovil.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.procyectomovil.Principal
import com.example.procyectomovil.databinding.ActivityLoginBinding
import com.google.firebase.FirebaseApp

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity(){

private lateinit var binding: ActivityLoginBinding


private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        auth = Firebase.auth



        binding.btnInicio.setOnClickListener{createLogin()}

    }

    private fun createLogin() {
        //Recupero la información que el usuario escribió en el App
        val email = binding.etEmail.text.toString()
        val clave = binding.etPassword.text.toString()

        Log.d("Autenticandose","Haciendo llamado de autenticación")
        //Utilizo el objeto auth para hacer el registro...
        auth.signInWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {  //Si se logró... se creo el usuario
                    Log.d("Autenticando","se autenticó")
                    val user = auth.currentUser
                    refresh(user)
                } else { //Si no se logró hubo un error...
                    Log.e("Autenticando","Error de Autenticación")
                    println(task.exception.toString())
                    Toast.makeText(baseContext,"Fallo", Toast.LENGTH_LONG).show()
                    refresh(null)
                }
            }
        Log.d("Autenticando","Sale del proceso...")
    }

    private fun refresh(user: FirebaseUser?) {
        if (user!=null){
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }
    }

    override fun onStart(){
        super.onStart()
        val user = auth.currentUser
        refresh(user)
    }




}

