package pro.hallpaz.votoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        analiseButton.setOnClickListener {
            // Pega a idade do\ campo de entrada
            val idade = idadeEditText.text.toString()
            // Exibe a idade no texto de saída
            respostaTextView.text = analisaIdade(idade.toInt())
        }
    }


    fun analisaIdade(idade: Int) =
        if (idade >= 18 && idade <= 70){
            "$idade É obrigado a votar"
        } else if (idade >= 16){
            "$idade\n Voto é facultativo"
        }
        else {
            "$idade Não pode votar ainda"
        }

}
