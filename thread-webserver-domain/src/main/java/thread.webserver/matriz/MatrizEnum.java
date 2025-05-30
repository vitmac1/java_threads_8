package thread.webserver.matriz;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum MatrizEnum {

    PEQUENA(100),
    MEDIA(500),
    GRANDE(1000);

    private final int tamanho;

    MatrizEnum(int tamanho) {
        this.tamanho = tamanho;
    }

    public static MatrizEnum getEnum(int tamanho) {

        return Stream.of(values())
                .filter(value -> value.getTamanho() == tamanho)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tamanho inválido: " + tamanho));
    }
}
