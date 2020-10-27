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

fun map(f: (Int)->Int, g: (Int)->Int, lista: List?): List?{
    return if (lista != null)
        List(f(g(lista.info)), map(f, g, lista.next))
    else null
}


fun main(){
    val f = {x:Int -> x+x}
    val g = {x:Int -> x*x}

    map(f, g, listOf(1,2,3,4))!!.imprimir()
    map(f, g, listOf(6,1,8,9))!!.imprimir()
    map(f, g, listOf(35,345,765,4678))!!.imprimir()
}









