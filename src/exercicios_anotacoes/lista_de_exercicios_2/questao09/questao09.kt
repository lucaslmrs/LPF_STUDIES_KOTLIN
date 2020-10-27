package exercicios_anotacoes.lista_de_exercicios_2.questao09

/*
TODO:
 9) Defina uma função que, dada uma lista e um valor, retorne um par de listas em que a
 primeira contém todos os elementos da lista inferiores a esse valor e a segunda lista
 contém todos os outros elementos.
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

fun twoFilters(lista: List?, f: (Int)->Boolean = {it<4}): Pair<List?, List?>{
    val g = {x: Int -> !f(x)}
    return Pair(filter(f, lista), filter(g, lista))
}


fun main(){
    println(twoFilters(listOf(1,2,3,4)))
    println(twoFilters(listOf()))
    println(twoFilters(listOf(2,2,2,2)))
    println(twoFilters(listOf(5,5,5,5)))
    println(twoFilters(listOf(-2,-2,-2,-2)))
    println(twoFilters(listOf(7,5,54,34,35,3,2,4665,8485,4858,-255423)))
}








