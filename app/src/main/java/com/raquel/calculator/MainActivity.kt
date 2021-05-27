package com.raquel.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import com.raquel.calculator.databinding.ActivityMainBinding

    class MainActivity : AppCompatActivity() {


        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val btDeCalcular = binding.btcalculomain
            val alturaSeekBar = binding.seekBar
            //val homem = binding.imageButton7 //BOTAO HOMEM MULHER AINDA NAO IMPLEMENTADO
            //val mulher = binding.imageButton6 //BOTAO HOMEM MULHER AINDA NAO IMPLEMENTADO
            //val pesoFun = binding.entradaPeso
            val alturaFun = binding.alturaSeekbarReferencia
           // val tirar = binding.editTextNumber

            alturaSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    alturaFun.text = progress.toString()
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    if (seekBar != null) {
                        alturaFun.text = seekBar.progress.toString()
                    }
                }
            })

            //VOU PEGAR A TEXTEDIT E BOTAR SNEEKBAR NO LUGAR
            btDeCalcular.setOnClickListener {
                val entradaPesoID = binding.entradaPeso.text.toString()

                if (entradaPesoID.isEmpty() /*|| homem.isPressed.not() || mulher.isPressed.not()*/) {
                    Toast.makeText(this, "Por favor, insira todas as informações", Toast.LENGTH_SHORT).show()
                } else {

                    //val alturaFun = binding.alturaSeekbarReferencia
                    //val alturaFunConversion = alturaFun.toString()
                    //val pesoFunConversion = Integer.parseInt(pesoFun.text.toString())
                    //val tirardeclaraddois = java.lang.Float.parseFloat(tirar.text.toString())
                    //val imcContas: Float =  pesoFunConversion / ((tirardeclaraddois/100) * (tirardeclaraddois/100))
                    //val intent = Intent(this@MainActivity, BomImcActivity::class.java)
                    calcularImc()
                    //startActivity(intent)
                }
            }

                   /* btDeCalcular.setOnClickListener {
                        val entradaPesoID = binding.entradaPeso.text.toString()

                        if (entradaPesoID.isEmpty() /*|| homem.isPressed.not() || mulher.isPressed.not()*/) {
                            Toast.makeText(this, "Por favor, insira todas as informações", Toast.LENGTH_SHORT).show()
                        } else {
                            calcularImc()
                        }
                    } */

        }
        private fun calcularImc() {
            val pesoFun = binding.entradaPeso
            val alturaFun = binding.alturaSeekbarReferencia
            val pesoFunConversion = Integer.parseInt(pesoFun.text.toString())
            val alturaFunConversion = java.lang.Float.parseFloat(alturaFun.text.toString())
            val imcConta: Float = pesoFunConversion / ((alturaFunConversion/100) * (alturaFunConversion/100))
            val guardar = imcConta.toString()

            val intent = Intent(this@MainActivity, BomImcActivity::class.java)
            intent.putExtra("RESULT", guardar)
            startActivity(intent)
        }
    }
