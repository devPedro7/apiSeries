package br.com.pedro.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    /*
    * METODO QUE MONTA A REQUISICAO HTTP
    * */
    public String obterDadosAPI(String endereco){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> resposta = null;

        try{
            resposta = client.send(requisicao, HttpResponse.BodyHandlers.ofString());
        }catch (IOException e){
            throw new RuntimeException(e);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        String json = resposta.body();
        return json;
    }
}
