package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client

@Client(value = "http://localhost:8081/cep/busca")
interface EnderecoClient {

//    // GET http://localhost:8081/cep/{cep}
//    @Get(value = "{cep")
//    fun consulta(cep: String) : HttpResponse<EnderecoResponse>

    @Get(consumes = [ MediaType.APPLICATION_XML ]) // Ou pela anotação abaixo
//    @Consumes(MediaType.APPLICATION_XML)
//    @Produces(MediaType.APPLICATION_XML) // Quando for enviar requisição XML
    fun consulta(@QueryValue cep: String) : HttpResponse<EnderecoResponse>
}