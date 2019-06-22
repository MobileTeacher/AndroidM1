package pro.hallpaz.perfilinvestidor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val respostas = intent.getIntArrayExtra("respostas")

        var texto = ""
        for (i in respostas){
            texto += " $i"
        }
        textView.text = texto

    }
}
