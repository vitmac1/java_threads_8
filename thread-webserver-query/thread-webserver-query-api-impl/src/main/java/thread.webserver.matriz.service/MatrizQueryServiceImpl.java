package thread.webserver.matriz.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thread.webserver.matriz.Matriz;
import thread.webserver.matriz.MatrizCache;
import thread.webserver.matriz.MatrizEnum;
import thread.webserver.matriz.util.MatrizProcessor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MatrizQueryServiceImpl implements MatrizQueryService {

    private final @NonNull
    MatrizCache matrizCache;

    @Override
    public Matriz processaMatriz(Integer tamanho, Integer threads) {

        log.debug("Iniciando processamento da matriz de tamanho: {} e número de threads: {} às {}",
                tamanho, threads, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));

        int tamanhoMatriz = MatrizEnum.getEnum(tamanho).getTamanho();

        Matriz matriz = matrizCache.getMatriz(tamanhoMatriz);

        return MatrizProcessor.processaMatriz(matriz, matriz, threads, tamanhoMatriz);
    }
}
