package com.example.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Criando as instâncias das views
        //Para que possam ser manipuladas no Kotlin
        val editTextPeso = findViewById<EditText>(R.id.edit_peso)
        val editTextAltura = findViewById<EditText>(R.id.edit_altura)
        val buttonCalcular = findViewById<Button>(R.id.button_calcular)
        val textViewResultado = findViewById<TextView>(R.id.text_view_resultado)

        //Adicionar um ouvinte de click no botão
        buttonCalcular.setOnClickListener {

            if(editTextPeso.text.isEmpty()){
                editTextPeso.error = "Peso é obrigatório"
            }
            else if(editTextAltura.text.isEmpty()){
                editTextAltura.error = "Altura é obrigatório"
            }
            else{
                val peso = editTextPeso.text.toString().toInt()
                val altura = editTextAltura.text.toString().toDouble()
                val imc = peso / (altura * altura)
                textViewResultado.text = String.format("%.2f", imc)
            }
        }
    }
}
