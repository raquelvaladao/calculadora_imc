package com.raquel.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.raquel.calculator.databinding.ActivityBomImcBinding

class BomImcActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBomImcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBomImcBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val textoResultadoActivity2 = binding.resultadoimc
        val generoText = binding.genero

        setupToolbar()

        val resultadoDaActivity1 = intent.getStringExtra("RESULT")
        val generoTextoBom = intent.getStringExtra("GENERO")

        textoResultadoActivity2.text = resultadoDaActivity1.toString()
       generoText.text = generoTextoBom.toString()



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



