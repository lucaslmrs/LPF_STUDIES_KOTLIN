package exercicios_anotacoes.lista_de_exercicios_2.questao05

/*
TODO:
 5) Reescreva a expressão
 map (f ,(map (g, l)))
 de forma que só uma chamada a map seja utilizada.
 */


class List(val info: Int, val next: List?){
    @JvmOverloads
    fun toString(lista: List? = this): String{ return if (lista != null) "${lista.info}, ${toString(lista.next)}" else "" }
    fun imprimir() { print("[${this.toString(this).substringBeforeLast(',')}]\n") }
}

fun listOf(vararg elems: Int):List? {
    return  if (elems.isNotEmpty()) List(elems[0], listOf(*elems.copyOfRange(1, elems.size))) else null
}

fun doubleMap(lista: List?, f: (Int)->Int = {it+it}, g: (Int)->Int = {it*it}): List?{
    return if (lista != null)
        List(f(g(lista.info)), doubleMap(lista.next))
    else null
}


fun main(){
    doubleMap(listOf(1,2,3,4))!!.imprimir()
    doubleMap(listOf(6,1,8,9))!!.imprimir()
    doubleMap(listOf(35,345,765,4678))!!.imprimir()
}









