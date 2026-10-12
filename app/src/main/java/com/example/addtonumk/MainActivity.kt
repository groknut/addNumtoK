package com.example.addtonumk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(v: View) {
        val etA = findViewById<EditText>(R.id.numA)
        val etB = findViewById<EditText>(R.id.numB)
        val tvSum = findViewById<TextView>(R.id.sum)

        val strA = etA.text.toString().trim()
        val strB = etB.text.toString().trim()

        if (strA.isEmpty() || strB.isEmpty()) {
            Toast.makeText(this, "Заполните оба поля", Toast.LENGTH_SHORT).show()
            tvSum.text = ""
            return
        }

        val a = strA.replace(',', '.').toDoubleOrNull()
        val b = strB.replace(',', '.').toDoubleOrNull()

        if (a == null || b == null) {
            Toast.makeText(this, "Введите корректные числа", Toast.LENGTH_SHORT).show()
            tvSum.text = ""
            return
        }

        val sum = a + b
        // Красиво выводим: без лишних нулей для целых результатов
        val strSum = if (sum % 1.0 == 0.0) sum.toLong().toString() else sum.toString()
        tvSum.text = strSum
    }
}