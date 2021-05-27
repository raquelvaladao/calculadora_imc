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
            val homem = binding.imageButton7 //BOTAO HOMEM MULHER AINDA NAO IMPLEMENTADO
            val mulher = binding.imageButton6 //BOTAO HOMEM MULHER AINDA NAO IMPLEMENTADO
            val alturaID = binding.alturaSeekbarReferencia

            alturaSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    alturaID.text = progress.toString()
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }
                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    if (seekBar != null) {
                        alturaID.text = seekBar.progress.toString()
                    }
                }
            })

            btDeCalcular.setOnClickListener {
                val entradaPesoID = binding.entradaPeso.text.toString()

                if (entradaPesoID.isEmpty() /*|| homem.isPressed.not() || mulher.isPressed.not()*/) {
                    Toast.makeText(this, "Por favor, insira todas as informações", Toast.LENGTH_SHORT).show()
                } else {
                    calcularImc()
                }
            }
        }

        private fun calcularImc() {
            val pesoFun = binding.entradaPeso
            val alturaFun = binding.alturaSeekbarReferencia
            val pesoFunConversion = Integer.parseInt(pesoFun.text.toString())
            val alturaFunConversion = java.lang.Float.parseFloat(alturaFun.text.toString())
            val imcConta: Float = pesoFunConversion / ((alturaFunConversion/100) * (alturaFunConversion/100))
            val guardar = imcConta.toString()

            val intent = Intent(this@MainActivity, BomImc::class.java)
            intent.putExtra("RESULT", guardar)
            startActivity(intent)
        }
    }




/*return if((peso!=null) && (altura!=null)){
    peso/altura*altura
} else 0.0
}

}
*/


