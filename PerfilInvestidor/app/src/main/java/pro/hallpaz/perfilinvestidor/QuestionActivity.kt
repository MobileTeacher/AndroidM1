package pro.hallpaz.perfilinvestidor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    val listaDePerguntas = perguntas
    var perguntaCorrente = 0

    val FINAL_TEXT_BUTTON = "Finalizar"
    val REGULAR_TEXT_BUTTON = "Próximo"
    val NOT_SELECTED = -1

    val respostas = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        //inicia com a pergunta corrente
        atualizarInterface(perguntaCorrente)

        configurarBotao()
    }

    fun configurarBotao(){
        proximo_button.setOnClickListener {
            // Log de debug para verificar o valor da perguntaCorrente
            Log.d("Pergunta", "$perguntaCorrente")
            val resposta = validarResposta()


            if ( resposta != NOT_SELECTED){
                perguntaCorrente += 1
                respostas.add(resposta)
                if (proximo_button.text == FINAL_TEXT_BUTTON){ // nova tela
                    // encerrar o questionario
                    val resultIntent = Intent(this,
                        ResultActivity::class.java)

                    resultIntent.putExtra("respostas", respostas.toIntArray())

                    startActivity(resultIntent)

                } else { // nova pergunta
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
        val radioButtons = listOf(a_radioButton,
                                b_radioButton,
                                c_radioButton,
                                d_radioButton,
                                e_radioButton)

        for (i in pergunta.alternativas.indices){
            radioButtons[i].text = pergunta.alternativas[i]
            radioButtons[i].visibility = View.VISIBLE
        }

        when(pergunta.alternativas.size){
            4 -> radioButtons[4].visibility = View.GONE
            3 -> {
                radioButtons[3].visibility = View.GONE
                radioButtons[4].visibility = View.GONE
            }
        }

//        a_radioButton.text = pergunta.alternativas[0]
//        b_radioButton.text = pergunta.alternativas[1]
//        c_radioButton.text = pergunta.alternativas[2]
//        d_radioButton.text = pergunta.alternativas[3]
//        e_radioButton.text = pergunta.alternativas[4]

        if (indice == listaDePerguntas.lastIndex){
            proximo_button.text = FINAL_TEXT_BUTTON
        }

    }

}
