package exercicios_anotacoes.lista_de_exercicios_2.questao08

/*
TODO:
 8) Escreva uma função que, dada uma lista de inteiros L, retorne uma tripla de listas (a, b,
 c) em que: a contenha os elementos ímpares de L, b os elementos divisíveis por 4 e c
 todos os outros elementos de L.
 */


class List(val info: Int, val next: List?){
    @JvmOverloads
    fun toString(lista: List? = this): String {
        fun toStringn(lista: List? = this): String{
            return if (lista != null) "${lista.info}, ${toStringn(lista.next)}"
            else ""
        }
        return "[${toStringn(this).substringBeforeLast(',')}]"
    }
    fun imprimir() { println(this.toString()) }
}


fun listOf(vararg elems: Int):List? {
    return  if (elems.isNotEmpty()) List(elems[0], listOf(*elems.copyOfRange(1, elems.size))) else null
}

fun filter(f: (Int)->Boolean, lista: List?): List?{
    return if (lista != null){
        if (f(lista.info))
            List(lista.info, filter(f, lista.next))
        else filter(f, lista.next)
    } else null
}

fun threeFilters(lista: List?, f: (Int)->Boolean = {it%2 == 1}, g: (Int)->Boolean = {it%4 == 0},
                 h: (Int)->Boolean = {!f(it) && !g(it)},): Triple<List?, List?, List?>{
    return Triple(filter(f, lista), filter(g, lista), filter(h, lista))
}


fun main(){
    println(threeFilters(listOf(1,2,3,4)))
    println(threeFilters(listOf()))
    println(threeFilters(listOf(2,2,2,2)))
    println(threeFilters(listOf(5,5,5,5)))
    println(threeFilters(listOf(-2,-2,-2,-2)))
}




