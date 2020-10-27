package exercicios_anotacoes.lista_de_exercicios_2.questao04

/*
TODO:
 4) Escreva uma função chamada filtraMapeiaReduz que recebe como entrada uma
 função do tipo (t -> Bool), outra função do tipo (t -> v) e outra função do tipo (v -> v ->
 v) e retorna uma função do tipo ([t] -> v) composta pela operação de filtragem com a
 primeira função de entrada, seguida por uma operação de mapeamento com a
 segunda função de entrada e seguida por uma operação de redução (fold) utilizando a
 terceira função de entrada.
 Exemplo:
 *Main> (filtraMapeiaReduz (<=2) (^2) (+)) [1,2,3,4]
 5
 */


class List(val info: Int, val next: List?){
    @JvmOverloads
    fun toString(lista: List? = this): String{ return if (lista != null) "${lista.info}, ${toString(lista.next)}" else "" }
    fun imprimir() { print("[${this.toString(this).substringBeforeLast(',')}]") }
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

fun map(f: (Int)->Int, lista: List?): List?{
    return if (lista != null)
        List(f(lista.info), map(f, lista.next))
    else null
}

fun reduce(f: (Int, Int)->Int, lista: List?): Int{
    return if (lista != null) {
        if (lista.next != null)
            f(lista.info, reduce(f, lista.next))
        else lista.info
    }
    else 0
}

fun filtraMapeiareduz(f: (Int)->Boolean, g: (Int)->Int, h: (Int, Int)->Int, lista: List?): Int{
    return reduce(h, map(g ,filter(f, lista)))
}


fun main(){
    val f = {x:Int -> x<=2}
    val g = {x:Int -> x*x}
    val h = {x:Int, y:Int -> x+y}

    println(filtraMapeiareduz(f, g, h, listOf(1,2,3,4)))
    println(filtraMapeiareduz(f, g, h, listOf()))
    println(filtraMapeiareduz(f, g, h, listOf(2,2,2,2)))
    println(filtraMapeiareduz(f, g, h, listOf(5,5,5,5)))
    println(filtraMapeiareduz(f, g, h, listOf(-2,-2,-2,-2)))
}