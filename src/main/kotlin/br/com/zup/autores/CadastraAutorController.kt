package br.com.zup.autores

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller(value = "/autores")
class CadastraAutorController {

    @Post
    fun cadastra(@Body @Valid request: NovoAutorRequest) {

        println("Requisicao => $request")

        val autor = request.paraAutor()

        println("Autor => ${autor.nome}")
    }
}