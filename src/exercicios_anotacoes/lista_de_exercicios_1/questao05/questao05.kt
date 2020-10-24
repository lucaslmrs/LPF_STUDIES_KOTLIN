package exercicios_anotacoes.lista_de_exercicios_1.questao05

import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.system.exitProcess

/*
TODO:
 5) Crie uma função que receba os coeficientes de uma equação de segundo grau
 ax2+bx+c na forma de uma tupla (a,b,c) e retorne as raízes desta equação. Trate o caso
 de raízes imaginárias indicando um erro.
 */


fun equationRoots(equation: Triple<Double, Double, Double>): Pair<Double, Double>?{
    val delta = sqrt( equation.second.pow(2) - (4 * equation.first * equation.third))
    val raizes = Pair((-equation.second + delta) / 2*equation.first, (-equation.second - delta) / 2*equation.first)
    if (raizes.first.isNaN() && raizes.second.isNaN()) {
        print("raizes imáginárias -> ")
        return null
    }
    else return raizes
}

fun main(){
    println(equationRoots(Triple(1.0, -1.0, -6.0)))
    println(equationRoots(Triple(1.0, 0.0, 0.0)))
    println(equationRoots(Triple(-6.0, 36.0, -59.0)))
}