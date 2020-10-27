package exercicios_anotacoes.lista_de_exercicios_2.questao07

/*
TODO:
 7) Agora implemente o oposto da função anterior, uma função perdeEnquanto que
 receba uma função booleana e uma lista e retorna uma lista com os elementos depois
 de deixarem de encaixarem na função.
 ex.: perdeEnquanto (<3) [1,2,0,1,3,5,7,12,2,4] = [3,5,7,12,2,4]
 */

class List(val info: Int, val next: List?){
    @JvmOverloads
    fun toString(lista: List? = this): String{ return if (lista != null) "${lista.info}, ${toString(lista.next)}" else "" }
    fun imprimir() { println("[${this.toString(this).substringBeforeLast(',')}]") }
}

fun listOf(vararg elems: Int):List? {
    return if (elems.isNotEmpty()) List(elems[0], listOf(*elems.copyOfRange(1, elems.size))) else null
}

fun perdeEnquanto(lista: List?, f: (Int)->Boolean = {it<3}): List?{
    return if (lista != null){
        if (f(lista.info)) return perdeEnquanto(lista.next)
        else return lista
    } else null
}

fun main(){
    perdeEnquanto(listOf(-1,0,1,2,3,4,5))!!.imprimir()
    perdeEnquanto(listOf(-3,-3,3,-1,0,1,2,3,4,5))!!.imprimir()
    perdeEnquanto(listOf(-1,0,1,2,3,4,5))!!.imprimir()
    // perdeEnquanto(listOf(3,-1,0,1,2,3,4,5))!!.imprimir() -> retorna uma lista nula por isso nao posso imprimir
}






