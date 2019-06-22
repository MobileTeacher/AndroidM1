package pro.hallpaz.perfilinvestidor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    val listaDePerguntas = perguntas
    var perguntaCorrente = 0
    val FINAL_TEXT_BUTTON = "Finalizar"
    val REGULAR_TEXT_BUTTON = "Próximo"
    val NOT_SELECTED = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        //inicia com a pergunta corrente
        atualizarInterface(perguntaCorrente)

        proximo_button.setOnClickListener {
            // Log de debug para verificar o valor da perguntaCorrente
            Log.d("Pergunta", "$perguntaCorrente")

            val resposta = validarResposta()
            if ( resposta != NOT_SELECTED){
                perguntaCorrente += 1
                if (proximo_button.text == FINAL_TEXT_BUTTON){
                    // encerrar o questionario
                    val resultIntent = Intent(this,
                        ResultActivity::class.java)
                    startActivity(resultIntent)

                } else {
                    if (perguntaCorrente < listaDePerguntas.size){
                        atualizarInterface(perguntaCorrente)
                    }
                }
            } else {
                Toast.makeText(this,
                            "Selecione uma resposta",
                            Toast.LENGTH_LONG).show()
            }

        }
    }

    fun validarResposta(): Int {
        val resposta = when(radiogroup.checkedRadioButtonId){
            a_radioButton.id -> 0
            b_radioButton.id -> 1
            c_radioButton.id -> 2
            d_radioButton.id -> 3
            else -> NOT_SELECTED // não está selecionado
        }
        return resposta
    }


    fun atualizarInterface(indice: Int){
        val pergunta = listaDePerguntas[indice]
        // desmarcar opção
        radiogroup.clearCheck()
        // atualiza texto da pergunta
        pergunta_textView.text = pergunta.texto

        //atualiza texto das alternativas
        a_radioButton.text = pergunta.alternativas[0]
        b_radioButton.text = pergunta.alternativas[1]
        c_radioButton.text = pergunta.alternativas[2]
        d_radioButton.text = pergunta.alternativas[3]

        if (indice == listaDePerguntas.lastIndex){
            proximo_button.text = FINAL_TEXT_BUTTON
        }

    }

}
