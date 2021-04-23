package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller(value = "/autores")
class CadastraAutorController(val autorRepository: AutorRepository) {

    @Post
    @Transactional
    fun cadastra(@Body @Valid request: NovoAutorRequest) {

        println("Requisicao => $request")

        val autor = request.paraAutor()
        autorRepository.save(autor)

        println("Autor => ${autor.nome}")
    }
}