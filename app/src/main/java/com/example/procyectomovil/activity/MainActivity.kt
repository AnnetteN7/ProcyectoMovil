package com.example.procyectomovil.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.procyectomovil.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

      private lateinit var binding: ActivityMainBinding



      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          binding = ActivityMainBinding.inflate(layoutInflater)
          setContentView(binding.root)


          binding.btnInicio.setOnClickListener{
              startActivity(Intent(this, LoginActivity::class.java))
          }

          binding.btnRegistro.setOnClickListener{
              startActivity(Intent(this, RegisterActivity::class.java))
          }
      }
}





