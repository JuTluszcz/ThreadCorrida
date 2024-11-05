import java.util.Random;

public class Carro implements Runnable {
    private String piloto;
    private int tempoAcumulado;
    private static final int NUMERO_DE_VOLTAS = 5;

    public Carro(String piloto) {
        this.piloto = piloto;
        this.tempoAcumulado = 0;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 1; i <= NUMERO_DE_VOLTAS; i++) {
            try {
                int tempoVolta = 1000 + random.nextInt(4000); // tempo entre 1 e 5 segundos
                Thread.sleep(tempoVolta); // Simula o tempo da volta
                tempoAcumulado += tempoVolta; // Acumula o tempo da volta
                System.out.println(piloto + " completou a volta " + i + " em " + tempoVolta + " ms.");
            } catch (InterruptedException e) {
                System.out.println(piloto + " foi interrompido.");
            }
        }
        
        System.out.println(piloto + " terminou a corrida com um tempo total de " + tempoAcumulado + " ms.");
    }

    public int getTempoAcumulado() {
        return tempoAcumulado;
    }
}
