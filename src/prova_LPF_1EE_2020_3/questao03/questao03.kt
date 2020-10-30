package prova_LPF_1EE_2020_3.questao03

/*
TODO:
 3) Uma árvore de Heap é um árvore Binária de inteiros onde o valor de cada nó é maior que todos os valores dos
 seus filhos. Implemente o tipo Arvore Heap e uma função para verificar se uma árvore de head é bem formada.
 */

data class HeapTree(val info: Int, val left: HeapTree?, val right: HeapTree?){
    fun isHeap(): Boolean{
        return if(this.left == null)
            if(this.right == null) true
            else if(this.info > this.right.info) this.right.isHeap()
            else false
        else if(this.right == null)
            if(this.info > this.left.info)
                this.left.isHeap()
            else false
        else if(this.info < this.left.info || this.info < this.right.info) false
        else this.left.isHeap() && this.right.isHeap()
    }
}

fun main(){
    val treeTRUE = HeapTree(10,
            HeapTree(9, left = HeapTree(7, null, null), right = HeapTree(3, null, null)),
            HeapTree(6, left = HeapTree(5, null, null), right = HeapTree(4, null, null)))

    assert(treeTRUE.isHeap())


    val treeFalse = HeapTree(10,
            HeapTree(8, left = HeapTree(5, null, null), right = HeapTree(4, null, null)),
            HeapTree(7, left = HeapTree(9, null, null), right = HeapTree(1, null, null)))

    assert(treeFalse.isHeap())


    println("TESTES OK!!")
}