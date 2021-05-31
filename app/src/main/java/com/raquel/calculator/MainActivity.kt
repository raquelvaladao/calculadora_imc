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

            fun InitView(){
                binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        binding.alturaSeekbarReferencia.text = progress.toString()
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        if (seekBar != null) {
                            binding.alturaSeekbarReferencia.text = seekBar.progress.toString()
                        }
                    }
                })

                binding.btcalculomain.setOnClickListener {
                    if (binding.entradaPeso.text.toString().isEmpty() || binding.generobt.checkedRadioButtonId == -1) {
                        Toast.makeText(this, "Por favor, insira todas as informações", Toast.LENGTH_SHORT).show()
                    } else {
                        calcularImc()
                    }
                }
            }
            InitView()
        }

        private fun generoMudar(){

        }
        private fun calcularImc() {
            val pesoFunConversion = binding.entradaPeso.text.toString().toInt()
            val alturaFunConversion = binding.alturaSeekbarReferencia.text.toString().toFloat()
            val imcConta: Float = pesoFunConversion / ((alturaFunConversion/100) * (alturaFunConversion/100))

            var generoTexto = "homem ou mulher"
            if(binding.homem.isChecked){
                generoTexto = "Homem"
            } else if (binding.mulher.isChecked){
                generoTexto = "Mulher"
            }

            if(imcConta >= 18.5 && imcConta < 29.9) {
                navigateIntentToShowResults(imcConta.toString(), generoTexto, BomImcActivity::class.java)
            } else if (imcConta < 18.5){
                navigateIntentToShowResults(imcConta.toString(), generoTexto, AltoImcActivity::class.java)
            } else if (imcConta >= 29.9) {
                navigateIntentToShowResults(imcConta.toString(), generoTexto, BaixoImcActivity::class.java)
            }
        }

        private fun <T> navigateIntentToShowResults(paramConta: String, paramGenero: String, paramActivity: Class<T>){
            val intent = Intent(this@MainActivity, paramActivity)
            intent.putExtra("RESULT", paramConta.toString())
            intent.putExtra("GENERO", paramGenero)
            startActivity(intent)
        }
    }
