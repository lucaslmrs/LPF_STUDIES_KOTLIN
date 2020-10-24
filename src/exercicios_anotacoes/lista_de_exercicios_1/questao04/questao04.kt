package exercicios_anotacoes.lista_de_exercicios_1.questao04

/*
TODO:
    4) Dado duas datas (d1,m1,a1) e (d2,m2,a2), tal que data1 <= data2, faça uma função que
    retorne quantos dias existem entre essas duas datas. Considere ano como 360 dias e mês como 30 dias.
 */


data class Data(val day: Int=0, val month: Int=0, val year: Int=0)


fun distanceDays(data1: Data, data2: Data): Int{
    return (data2.year - data1.year)*360 + (data2.month - data1.month)*30 + (data2.day - data1.day)
}


fun main(){
    println(distanceDays(Data(1, 1, 1), Data(2, 2, 2)))
    println(distanceDays(Data(30, 12, 2019), Data(1, 1, 2020)))
    println(distanceDays(Data(3,5,1999), Data(24,10,2020)))
}