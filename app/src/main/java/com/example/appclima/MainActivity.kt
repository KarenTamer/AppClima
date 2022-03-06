package com.example.appclima
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

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

        if (Network.isNetworkAvailable(this)) {
            // ejecutar solicitud HTTP

            solicitudHTTPVolley("http://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&appid=05ad87465ff065400063d1bacfdeb6f9&units=metric&lang=es")

            //05ad87465ff065400063d1bacfdeb6f9
            //Ciudad de Orizaba 3522307
            //Ciudad de Berlin 2950159
            //Ciudad de Mexico 3530597
            //Ciudad de Colima 4013516

        } else {
            // mostrar mensaje de error
            Toast.makeText(this, "No hay red", Toast.LENGTH_SHORT).show()
        }

        /*
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

    */
    }

    private fun solicitudHTTPVolley(url:String){
        val queue = Volley.newRequestQueue(this)

        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String>{
                response ->
            try {
                Log.d("solicitudHTTPVolley", response)

                val gson = Gson()
                val ciudad = gson.fromJson(response, Ciudad::class.java)

                tvCiudad?.text = ciudad.name
                tvGrados?.text = ciudad.main?.temp.toString() + "º"
                tvEstatus?.text = ciudad.weather?.get(0)?.description

            }catch (e: Exception){

            }
        }, Response.ErrorListener {  })

        queue.add(solicitud)
    }
}