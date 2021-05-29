package com.raquel.calculator

import android.content.Intent
import android.net.sip.SipSession
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
            val generoBotoes = binding.generobt

            val alturaFun = binding.alturaSeekbarReferencia


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



            btDeCalcular.setOnClickListener {
                val entradaPesoID = binding.entradaPeso.text.toString()

                if (entradaPesoID.isEmpty() || generoBotoes.checkedRadioButtonId == -1) {
                    Toast.makeText(this, "Por favor, insira todas as informações", Toast.LENGTH_SHORT).show()
                } else {
                    calcularImcGenero()
                }
            }


        }
        private fun calcularImcGenero() {
            val pesoFun = binding.entradaPeso
            val alturaFun = binding.alturaSeekbarReferencia
            val pesoFunConversion = Integer.parseInt(pesoFun.text.toString())
            val alturaFunConversion = java.lang.Float.parseFloat(alturaFun.text.toString())
            val imcConta: Float = pesoFunConversion / ((alturaFunConversion/100) * (alturaFunConversion/100))
            val guardar = imcConta.toString()


            var generoTexto = "homem ou mulher"
            val generoHomembt = binding.homem
            val generoMulher = binding.mulher
            if(generoHomembt.isChecked){
                generoTexto = "Homem"
            } else if (generoMulher.isChecked){
                generoTexto = "Mulher"
            }


            if(imcConta >= 18.5 && imcConta < 29.9) {
                val intent = Intent(this@MainActivity, BomImcActivity::class.java)
                intent.putExtra("RESULT", guardar)
                intent.putExtra("GENERO", generoTexto)
                startActivity(intent)
            } else if (imcConta < 18.5){
                val intent = Intent(this@MainActivity, BaixoImcActivity::class.java)
                intent.putExtra("RESULT", guardar)
                intent.putExtra("GENERO", generoTexto)
                startActivity(intent)
            } else if (imcConta >= 29.9) {
                val intent = Intent(this@MainActivity, AltoImcActivity::class.java)
                intent.putExtra("RESULT", guardar)
                intent.putExtra("GENERO", generoTexto)
                startActivity(intent)
            }
        }
    }
