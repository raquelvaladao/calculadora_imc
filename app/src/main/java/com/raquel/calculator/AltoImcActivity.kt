package com.raquel.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raquel.calculator.databinding.ActivityAltoImcBinding

class AltoImcActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAltoImcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alto_imc)
        binding = ActivityAltoImcBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val textoResultadoActivity3 = binding.resultadoimcalto
        val generoTextoAlto = binding.genero3

        setupToolbar()

        val resultadoDaActivity1 = intent.getStringExtra("RESULT")
        val generoAlto = intent.getStringExtra("GENERO")

        textoResultadoActivity3.text = resultadoDaActivity1.toString()
        generoTextoAlto.text = generoAlto.toString()


    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    private fun setupToolbar(){
        supportActionBar?.apply{
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

    }
}