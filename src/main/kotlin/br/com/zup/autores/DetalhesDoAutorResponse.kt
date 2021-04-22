package br.com.zup.autores

class DetalhesDoAutorResponse(autor: Autor) {
    val nome: String = autor.nome
    val email: String = autor.email
    val descricao: String = autor.descricao
}