package com.raquel.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raquel.calculator.databinding.ActivityBomImcBinding

class BomImc : AppCompatActivity() {
    private lateinit var binding: ActivityBomImcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBomImcBinding.inflate(layoutInflater)
        setContentView(binding.root)
       val textoResultadoActivity2 = binding.resultadoimc
       val btVoltar = binding.voltar

        val resultadoDaActivity1 = intent.getStringExtra("RESULT")

        textoResultadoActivity2.text = resultadoDaActivity1

        btVoltar.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}


