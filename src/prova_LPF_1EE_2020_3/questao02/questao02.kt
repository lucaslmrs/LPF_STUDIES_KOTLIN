package prova_LPF_1EE_2020_3.questao02

/*
TODO:
 2) Escreva uma função para converter uma lista imutável de kotlin em uma lista encadeada tradicional e
 outra para fazer a conversão inversa.
       list2Node(listOf(1,2)) = node2List(Node(1,Node(2,null))) = listOf(1,2)
 */

class LinkedList<C>(val info: C?, val next: LinkedList<C>?)

fun linkedListOf(vararg elems: Int):LinkedList<Int>? {
    return  if (elems.isNotEmpty()) LinkedList(elems[0], linkedListOf(*elems.copyOfRange(1, elems.size))) else null
}

fun list2Node(lista: List<Int>): LinkedList<Int>{
    return if (lista.size > 1) LinkedList(lista[0], list2Node(lista.subList(1, lista.size)))
    else LinkedList(lista[0], null)
}

fun node2List(lista: LinkedList<Int>?): List<Int>{
    return if (lista?.info != null) listOf(lista.info).plus(node2List(lista.next))
    else listOf()
}

fun main(){
    assert(list2Node(listOf(1,2,3,4,5)) == linkedListOf(1,2,3,4,5))
    assert(list2Node(listOf(32,23324,234,453,56,56756,7435,6)) == linkedListOf(32,23324,234,453,56,56756,7435,6))
    assert(list2Node(listOf(10,9,8,7,6,5,4,3,2,1)) == linkedListOf(10,9,8,7,6,5,4,3,2,1))

    assert(listOf(1,2,3,4,5) == node2List(linkedListOf(1,2,3,4,5)))
    assert(listOf(32,23324,234,453,56,56756,7435,6) == node2List(linkedListOf(32,23324,234,453,56,56756,7435,6)))
    assert(listOf(10,9,8,7,6,5,4,3,2,1) == node2List(linkedListOf(10,9,8,7,6,5,4,3,2,1)))
    println("TESTES OK!!")
}