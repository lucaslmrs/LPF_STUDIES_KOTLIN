package exercicios_anotacoes.lista_de_exercicios_1.questao02

/*
TODO:
 2) Faça uma função que recebe duas listas, uma de dividendos e outra de divisores e
    retorne uma terceira lista formada por todos os dividendos que são divisíveis pelos
    divisores.
 */

class List(val info: Int?, val next: List?){
    @JvmOverloads
    fun toString(lista: List? = this): String{ return if (lista != null) "${lista.info}, ${toString(lista.next)}" else "" }
    fun imprimir() { print("[${this.toString(this).substringBeforeLast(',')}]") }
}

fun divisiveis(dividendos: List?, divisores: List?): List{

    fun isDivisivel(number: Int, divisores: List?): Boolean{
        if (divisores != null)
            return if(number % divisores.info!! == 0) isDivisivel(number, divisores.next) else return false
        else return true
    }

    if (dividendos != null) {
        return if(isDivisivel(dividendos.info!!, divisores))
            List(dividendos.info, divisiveis(dividendos.next, divisores))
        else divisiveis(dividendos.next, divisores)
    }
    return List(null, null)
}


fun main() {
    val dividendos = List(15, List(30, List(12, List(24, List(48, List(100, null))))))
    val divisores = List(2, List(3, List(4, null)))
    divisiveis(dividendos, divisores).imprimir()
}