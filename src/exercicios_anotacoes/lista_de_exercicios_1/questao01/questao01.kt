package exercicios_anotacoes.lista_de_exercicios_1.questao01

/*
TODO:
 1) Implemente uma função de divisão entre inteiros sem utilizar os operadores pré-
    definidos de Haskell, com exceção para soma (+) e subtração (-).
 */

fun divisao(a: Int, b: Int): Int{ return if (a > 0) 1 + divisao(a - b, b) else 0 }

fun main() {
    print(divisao(6, 1))
}