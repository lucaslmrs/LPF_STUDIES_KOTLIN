package prova_LPF_1EE_2020_3.questao01

/*
TODO:
 1) Escreva uma função para gerar as seguintes sequencias de valores:
 .
 a) Uma progressão aritmética de valor inicial vo, razão r, e comprimento n (passados como argumentos)
     pa(2,3,5) = [2,5,8,11,14]
 .
 b) A sequencia dos n primeiros números de fibonacci.
     fib(7) = [1,1,2,3,5,8,13]
 .
 Para cada uma dos ítens acima faça uma versão que retorne uma lista imutável da biblioteca de Kotlin e outra
 retornando uma classe de lista encadeada implementada por você.
 */

class LinkedList<C>(val info: C?, val next: LinkedList<C>?){
    @JvmOverloads
    fun toString(lista: LinkedList<C>? = this): String{
        return if (lista?.info != null) "${lista.info}, ${toString(lista.next)}" else ""
    }
    fun imprimir() { println("[${this.toString(this).substringBeforeLast(',')}]") }
}


fun paLinkedList(v0: Double, r: Double, n: Int): LinkedList<Double>{
    return if (n > 0) LinkedList(v0, paLinkedList(v0+r, r, n-1)) else LinkedList(null, null)
}

fun paImutableList(v0: Double, r: Double, n: Int): List<Double>{
    return if (n > 0) listOf(v0).plus(paImutableList(v0+r, r, n-1)) else listOf()
}

fun fibonacciLinkedList(n: Int): LinkedList<Int>{
    fun fibonacci(n: Int): Int{
        return if(n == 1) 1
        else if(n == 2) 1
        else fibonacci(n-1) + fibonacci(n-2)
    }
    fun percorreFib(n: Int, count: Int): LinkedList<Int>{
        return if (n >= count) LinkedList(fibonacci(count), percorreFib(n, count+1)) else LinkedList(null, null)
    }
    return percorreFib(n, 1)
}

fun fibonacciImutableList(n: Int): List<Int>{
    fun fibonacci(n: Int): Int{
        return if(n == 1) 1
        else if(n == 2) 1
        else fibonacci(n-1) + fibonacci(n-2)
    }
    fun percorreFib(n: Int, count: Int): List<Int>{
        return if (n >= count) listOf(fibonacci(count)).plus(percorreFib(n, count + 1)) else listOf()
    }
    return percorreFib(n, 1)
}

fun main(){
    println("Testes de PA")
    paLinkedList(2.0,3.0,5).imprimir()
    println(paImutableList(2.0,3.0,5))

    paLinkedList(0.5, 0.5, 10).imprimir()
    println(paImutableList(0.5, 0.5, 10))

    println("\n\nTestes de Fibonacci")
    fibonacciLinkedList(10).imprimir()
    println(fibonacciImutableList(10))

    fibonacciLinkedList(0).imprimir()
    println(fibonacciImutableList(0))
}