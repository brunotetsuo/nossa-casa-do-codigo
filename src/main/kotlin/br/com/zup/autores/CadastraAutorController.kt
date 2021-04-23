package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller(value = "/autores")
class CadastraAutorController(val autorRepository: AutorRepository) {

    @Post
    @Transactional
    fun cadastra(@Body @Valid request: NovoAutorRequest) : HttpResponse<Any> {

        println("Requisicao => $request")

        val autor = request.paraAutor()

        println("Autor ${autor.nome}")
        autorRepository.save(autor)

        val uri = UriBuilder.of("/autores/{id}")
                            .expand(mutableMapOf(Pair("id", autor.id)))

        return HttpResponse.created(uri)
    }
}