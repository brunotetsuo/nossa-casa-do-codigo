package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client(value = "http://localhost:8081/cep/")
interface EnderecoClient {

    // GET http://localhost:8081/cep/{cep}
    @Get(value = "{cep")
    fun consulta(cep: String) : HttpResponse<EnderecoResponse>
}