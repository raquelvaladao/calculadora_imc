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

        val resultadoDaActivity1 = intent.getStringExtra("RESULT")
        textoResultadoActivity3.text = resultadoDaActivity1.toString()
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

