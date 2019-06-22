package pro.hallpaz.perfilinvestidor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_button.setOnClickListener {
            // cria a "mensagem" solicitando uma nova tela
            val questionIntent = Intent(this,
                QuestionActivity::class.java)
            // envia a mensagem
            startActivity(questionIntent)
        }
    }
}
