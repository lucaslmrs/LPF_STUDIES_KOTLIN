package exercicios_anotacoes.lista_de_exercicios_2.questao03

/*
TODO:
 3) Implemente a função dobrarSoma que recebe uma lista de inteiros e retorna um
 somatório do dobro dos elementos da lista.
 ex.: dobrarSoma [1,2,3] = 2+4+6=12
 */

class List(val info: Int, val next: List?){
    @JvmOverloads
    fun toString(lista: List? = this): String{ return if (lista != null) "${lista.info}, ${toString(lista.next)}" else "" }
    fun imprimir() { print("[${this.toString(this).substringBeforeLast(',')}]") }
}

fun listOf(vararg elems: Int):List? {
    return  if (elems.isNotEmpty()) List(elems[0], listOf(*elems.copyOfRange(1, elems.size))) else null
}

fun dobrarSoma(lista: List?): Int{ return if(lista != null) lista.info*2 + dobrarSoma(lista.next) else 0 }

fun main(){
    println(dobrarSoma(listOf(10, 20, 30)))
    println(dobrarSoma(listOf(1000, 1000, 1000)))
    println(dobrarSoma(listOf(-1, -1, -1)))
    println(dobrarSoma(listOf(0, 0, 0)))
}

