package com.example.procyectomovil

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
        val email = binding.etEmail.text.toString()
        val clave = binding.etPassword.text.toString()

        auth.createUserWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this){ task ->
                if (task.isSuccessful){
                    val user = auth.currentUser
                    refresh(user)
                } else{
                    Toast.makeText(baseContext,getString(R.string.msg_failure),Toast.LENGTH_LONG).show()
                    refresh(null)
                }
            }
    }

    private fun refresh(user: FirebaseUser?) {
        if (user!=null){
            val intent = Intent(this,Principal::class.java)
            startActivity(intent)
        }
    }

    override fun onStart(){
        super.onStart()
        val user = auth.currentUser
        refresh(user)
    }




}

