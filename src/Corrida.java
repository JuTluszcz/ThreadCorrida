
public class Corrida {
    public static void main(String[] args) {
        Carro carroSchumacher = new Carro("Schumacher");
        Carro carroBarrichelo = new Carro("Barrichelo");

        Thread threadSchumacher = new Thread(carroSchumacher);
        Thread threadBarrichelo = new Thread(carroBarrichelo);

        // Inicia as threads
        threadSchumacher.start();
        threadBarrichelo.start();

        try {
            // Aguarda ambas as threads terminarem
            threadSchumacher.join();
            threadBarrichelo.join();
        } catch (InterruptedException e) {
            System.out.println("A corrida foi interrompida.");
        }

        // Exibe o resultado
        int tempoSchumacher = carroSchumacher.getTempoAcumulado();
        int tempoBarrichelo = carroBarrichelo.getTempoAcumulado();

        System.out.println("\nResultado Final:");
        System.out.println("Schumacher: " + tempoSchumacher + " ms");
        System.out.println("Barrichelo: " + tempoBarrichelo + " ms");

        if (tempoSchumacher < tempoBarrichelo) {
            System.out.println("Schumacher venceu!");
        } else if (tempoSchumacher > tempoBarrichelo) {
            System.out.println("Barrichelo venceu!");
        } else {
            System.out.println("Empate!");
        }
    }
}
