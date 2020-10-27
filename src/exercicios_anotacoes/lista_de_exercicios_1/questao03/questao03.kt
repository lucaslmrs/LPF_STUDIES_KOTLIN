package exercicios_anotacoes.lista_de_exercicios_1.questao03

/*
TODO: 3) Implemente a função de interseção entre duas listas, ou seja, que retorna apenas os
         elementos que estão presentes em ambas.
 */


class List<C>(val info: C?, val next: List<C>?){
    @JvmOverloads
    fun toString(lista: List<C>? = this): String{ return if (lista != null) "${lista.info}, ${toString(lista.next)}" else "" }
    fun imprimir() { print("[${this.toString(this).substringBeforeLast(',')}]") }

    fun contains(e: C): Boolean{
        return if (e == this.info) true
        else if (this.next != null) this.next.contains(e)
        else false
    }
}

fun intersection(a: List<Int>?, b: List<Int>?): List<Int>? {
    return if (a == null || b == null) null
    else if (b.contains(a.info!!)) List(a.info, intersection(a.next, b))
    else intersection(a.next, b)
}


fun main(){
    val a = List(15, List(30, List(12, List(24, List(48, List(100, null))))))
    val b = List(100, List(12, List(24, List(50, null))))
    intersection(a, b)!!.imprimir()
}

