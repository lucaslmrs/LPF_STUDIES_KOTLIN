package prova_LPF_1EE_2020_3.questao04

/*
TODO:
 4) Escreva uma função para calcular a lista de suas raizes inteiras dentre um intervalo dado. Exemplo:
 raizes( {x -> x * x - 4 }, -10, 10) = listOf(-2,2)
 */

fun raizes(nInicio: Int, nFinal: Int, f: (Int)->Boolean = {it*it-4 == 0 }): List<Int>{
    fun filter(f: (Int)->Boolean, lista: List<Int>): List<Int>{
        return if (lista.isNotEmpty()){
            if (f(lista[0]))
                listOf(lista[0]).plus(filter(f, lista.subList(1, lista.size-1)))
            else filter(f, lista.subList(1, lista.size))
        } else listOf()
    }
    fun listOfIntRange(nInicio: Int, nFinal: Int): List<Int>{
        return if (nInicio != nFinal) listOf(nInicio).plus(listOfIntRange(nInicio+1, nFinal))
        else listOf(nInicio)
    }
    return filter(f, listOfIntRange(nInicio, nFinal))
}

fun main(){
    assert(raizes(-10, 10) == listOf(-2,2))
    assert(raizes(-10, 10, {it*it-9==0}) == listOf(-3,3))
    assert(raizes(-100, 100, {it*it-25==0}) == listOf(-5,5))
    assert(raizes(-100, 100, {it*it-81==0}) == listOf(-9,9))
    println("TESTES OK!!")
}