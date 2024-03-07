import java.util.Random;
import static java.lang.Integer.valueOf;

public class Sistema {
    private Random dados;
    private int seq_1;
    private int seq_2;
    private int seq_3;
    private String seq_4;

    public void limpaTela() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("\r\n");
        }
        //===
    }

    public String Gerar_ISBN() {
        dados = new Random();

        seq_1 = dados.nextInt(90) + 100;
        seq_2 = dados.nextInt(10) + 1;
        seq_3 = dados.nextInt(10) + 1;
        seq_4 = String.valueOf(seq_1) + String.valueOf(seq_2) + String.valueOf(seq_3);

        return seq_4;
        //===
    }
}