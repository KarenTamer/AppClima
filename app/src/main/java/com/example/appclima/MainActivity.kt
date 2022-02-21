package com.example.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var tvCiudad: TextView? = null
    var tvGrados: TextView? = null
    var tvEstatus: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstatus)

        val ciudad = intent.getStringExtra("com.vidamrr.appclima.ciudades.CIUDAD")



        Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show()
        val ciudadvr = Ciudad("Ciudad de Orizaba", grados = 15, estatus = "Soleado")
        val ciudadbr = Ciudad("Ciudad de Berlin", grados = 30, estatus = "Cielo despejados")
        if (ciudad == "ciudad-orizaba"){
            //mostrar información de ciudadvr
            tvCiudad?.text = ciudadvr.nombre
            tvGrados?.text = ciudadvr.grados.toString() + "°"
            tvEstatus?.text = ciudadvr.estatus


        } else if (ciudad == "ciudad-berlin"){
           //mostrar información de ciudadbr

            tvCiudad?.text = ciudadbr.nombre
            tvGrados?.text = ciudadbr.grados.toString() + "°"
            tvEstatus?.text = ciudadbr.estatus
        } else{
            Toast.makeText(this, "No se encuentra la informacion", Toast.LENGTH_SHORT).show()
        }

    }
}