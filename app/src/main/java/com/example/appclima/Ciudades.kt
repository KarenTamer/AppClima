package com.example.appclima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Ciudades : AppCompatActivity() {

    val TAG = "com.vidamrr.appclima.ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val bVeracruz = findViewById<Button>(R.id.bVeracruz)
        val bBerlin = findViewById<Button>(R.id.bBerlin)
        val bMexico = findViewById<Button>(R.id.bMexico)
        val bColima = findViewById<Button>(R.id.bColima)

        bVeracruz.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "3522307")
            startActivity(intent)
        })

        bBerlin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "2950159")
            startActivity(intent)
        })
        bMexico.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "3530597")
            startActivity(intent)
        })
        bColima.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "4013516")
            startActivity(intent)
        })
    }
}