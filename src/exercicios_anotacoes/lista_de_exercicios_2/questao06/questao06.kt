package exercicios_anotacoes.lista_de_exercicios_2.questao06

/*
TODO:
 6) Implemente a função aceitaEnquanto que receba uma função booleana e uma lista do
 tipo de entrada da função e retorna uma lista com os elementos enquanto se
 encaixam na função booleana.
 ex.: aceitaEnquanto (<3) [1,2,0,1,3,5,7,12,2,4] = [1,2,0,1]
*/

class List(val info: Int, val next: List?){
    @JvmOverloads
    fun toString(lista: List? = this): String{ return if (lista != null) "${lista.info}, ${toString(lista.next)}" else "" }
    fun imprimir() { println("[${this.toString(this).substringBeforeLast(',')}]") }
}

fun listOf(vararg elems: Int):List? {
    return if (elems.isNotEmpty()) List(elems[0], listOf(*elems.copyOfRange(1, elems.size))) else null
}

fun aceitaEnquanto(lista: List?, f: (Int)->Boolean = {it < 3}): List?{
    return if (lista != null){
        if (f(lista.info))
            List(lista.info, aceitaEnquanto(lista.next))
        else return null
    } else null
}

fun main(){
    aceitaEnquanto(listOf(-1,0,1,2,3,4,5))!!.imprimir()
    aceitaEnquanto(listOf(-3,-3,3,-1,0,1,2,3,4,5))!!.imprimir()
    aceitaEnquanto(listOf(-1,0,1,2,3,4,5))!!.imprimir()
    // aceitaEnquanto(f, listOf(3,-1,0,1,2,3,4,5))!!.imprimir() -> retorna uma lista nula por isso nao posso imprimir
}