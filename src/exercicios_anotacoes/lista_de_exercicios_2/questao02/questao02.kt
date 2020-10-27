package exercicios_anotacoes.lista_de_exercicios_2.questao02

/*
TODO:
 Crie uma função que ao receber uma string retorne quantas vezes cada caracter
 apareceu nesta. Os caracteres que não possuírem ocorrência na string não devem
 aparecer na contagem. Exemplo:
 main > qtosCaracteres "cachorro"
 > [(’a’,1),(’c’,2),(’h’,1),(’o’,2),(’r’,2)]
 main > qtosCaracteres "Carla"
 > [(’a’,2),(’l’,1),(’r’,1),(’C’,1)]
 */


class Hash(val key: Char?, val info: Int?, val next: Hash?){

    @JvmOverloads
    fun toString(hash: Hash? = this): String{
        return if (hash != null) "(${hash.key}, ${hash.info}), ${toString(hash.next)}" else ""
    }

    fun imprimir() { println("{${this.toString(this).substringBeforeLast(',')}}") }

    fun containsKey(e: Char): Boolean{
        return if (e == this.key) true
        else if (this.next != null) this.next.containsKey(e)
        else false
    }

    fun add(key: Char, info: Int): Hash{
        if(this.next == null)
            return Hash(this.key, this.info, Hash(key, info, null))
        else
            return Hash(this.key, this.info, this.next.add(key, info))
    }

    fun maisUm(key: Char, info: Int): Hash{
        if (key.toLowerCase() != this.key!!.toLowerCase()){
            if (this.next == null)
                return Hash(this.key, this.info, Hash(key, info, null))
            else
                return Hash(this.key, this.info, this.next.maisUm(key, info))
        } else
            return Hash(this.key, this.info!! + 1, this.next)
    }
}


fun quantosCaracteres(input: String): Hash{
    fun percorre(input: String, hash: Hash?): Hash{
        if(input.length > 1)
            return percorre(input.substring(1), hash!!.maisUm(input[0], 1))
        else return hash!!.maisUm(input[0], 1)
    }
    return if(input.length > 1) percorre(input.substring(1), Hash(input[0], 1, null))
    else Hash(input[0], 1, null)
}


fun main(){
    quantosCaracteres("Cachorro").imprimir()
    quantosCaracteres("Carla").imprimir()
    quantosCaracteres("c").imprimir()
}