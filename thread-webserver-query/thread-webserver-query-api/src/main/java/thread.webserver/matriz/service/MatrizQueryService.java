package thread.webserver.matriz.service;

import thread.webserver.matriz.Matriz;

public interface MatrizQueryService {

    Matriz processaMatriz(Integer tamanho, Integer threads);
}
