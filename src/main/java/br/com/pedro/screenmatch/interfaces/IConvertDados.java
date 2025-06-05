package br.com.pedro.screenmatch.interfaces;

public interface IConvertDados {

   <T> T obterDados(String json, Class<T> classe);

}
