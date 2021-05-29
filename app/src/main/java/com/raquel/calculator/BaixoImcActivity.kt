package com.raquel.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raquel.calculator.databinding.ActivityBaixoImcBinding

class BaixoImcActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaixoImcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaixoImcBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_baixo_imc)
        setContentView(binding.root)
        setupToolbar()
        val textoResultadoActivity3 = binding.resultadoimcbaixo
        val generoTextoBaixo = binding.genero2

        val resultadoDaActivity1 = intent.getStringExtra("RESULT")
        val generoBaixo = intent.getStringExtra("GENERO")

        textoResultadoActivity3.text = resultadoDaActivity1.toString()
        generoTextoBaixo.text = generoBaixo.toString()
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

