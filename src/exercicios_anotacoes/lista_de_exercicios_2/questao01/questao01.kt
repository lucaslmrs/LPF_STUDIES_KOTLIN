package exercicios_anotacoes.lista_de_exercicios_2.questao01

/*
TODO:
 1) Construa uma função que retorne os n primeiros termos de uma sequência de
 Fibonacci.
 ex.: fibo 6 = [1,1,2,3,5,8]
 */

class List<C>(val info: C?, val next: List<C>?){
    @JvmOverloads
    fun toString(lista: List<C>? = this): String{ return if (lista != null) "${lista.info}, ${toString(lista.next)}" else "" }
    fun imprimir() { print("[${this.toString(this).substringBeforeLast(',')}]") }
}

/*
    fib(1) = 1
    fib(2) = 1
    fib(3) = fib(2) + fib(1)
    ...
    fib(n) = fib(n-1) + fib(n-2)
 */

fun fibonacciList(n: Int): List<Int>?{
    fun fibonacci(n: Int): Int{
        return if(n == 1) 1
        else if(n == 2) 1
        else fibonacci(n-1) + fibonacci(n-2)
    }

    fun percorreFib(n: Int, count: Int): List<Int>?{
        return if (n >= count) List<Int>(fibonacci(count), percorreFib(n, count+1)) else null
    }

    return percorreFib(n, 1)
}

fun main(){
    fibonacciList(20)!!.imprimir()
}