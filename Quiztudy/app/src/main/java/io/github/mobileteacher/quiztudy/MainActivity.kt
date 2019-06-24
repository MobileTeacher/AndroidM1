package io.github.mobileteacher.quiztudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        start_button.setOnClickListener {
            // cria a "mensagem" solicitando uma nova tela
            val questionIntent = Intent(
                this,
                QuestionActivity::class.java
            )
            // envia a mensagem
            startActivity(questionIntent)
        }
    }
}
