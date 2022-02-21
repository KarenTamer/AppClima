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
        val ciudadmx = Ciudad("Ciudad de Mexico", grados = 13, estatus = "Nublado")
        val ciudadco = Ciudad("Ciudad de Colima", grados = 23, estatus = "Despejado")


        when (ciudad){
            "ciudad-orizaba" -> {//mostrar información de ciudadvr
                tvCiudad?.text = ciudadvr.nombre
                tvGrados?.text = ciudadvr.grados.toString() + "°"
                tvEstatus?.text = ciudadvr.estatus }
            "ciudad-berlin" -> {//mostrar información de ciudadbr
                tvCiudad?.text = ciudadbr.nombre
                tvGrados?.text = ciudadbr.grados.toString() + "°"
                tvEstatus?.text = ciudadbr.estatus }
            "ciudad-mexico" -> {//mostrar información de ciudadmx
                tvCiudad?.text = ciudadmx.nombre
                tvGrados?.text = ciudadmx.grados.toString() + "°"
                tvEstatus?.text = ciudadmx.estatus }
            "ciudad-colima" -> {//mostrar información de ciudadco
                tvCiudad?.text = ciudadco.nombre
                tvGrados?.text = ciudadco.grados.toString() + "°"
                tvEstatus?.text = ciudadco.estatus }
        }

    }
}