package pro.hallpaz.perfilinvestidor

val pergunta1 = Pergunta(
    "Por quanto tempo você pretende deixar seu dinheiro investido?",
        listOf("Menos de 6 meses ",
            "Entre 6 meses e 1 ano",
            "Entre 1 ano e 3 anos",
            "Acima de 3 anos")
    )

val pergunta2 = Pergunta(
    "Qual o objetivo desse investimento?",
    listOf("Preservação do capital para não perder valor ao longo do tempo,\n" +
            "assumindo baixos riscos de perdas",
        "Aumento gradual do capital ao longo do tempo, assumindo riscos\n" +
                "moderados",
        "Aumento do capital acima da taxa de retorno média do mercado, mesmo\n" +
                "que isso implique assumir riscos de perdas elevadas",
        "Obter no curto prazo retornos elevados e signi\u001Fcativamente acima da taxa\n" +
                "de retorno média do mercado, assumindo riscos elevados")
)

val perguntas = listOf(pergunta1, pergunta2)