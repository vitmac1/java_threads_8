package thread.webserver.matriz;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Matriz {

    private int[][] matriz;

    public Matriz() {}

    public Matriz(int[][] matriz) {
        this.matriz = matriz;
    }
}
