import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContoBancario contoBancario = new ContoBancario(1000);

        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new UtenteBancomat(contoBancario), "Utente " + (i + 1));
            threads[i].start();
        }

        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Premi Invio per terminare il programma...");
            scanner.nextLine();

            System.exit(0);
        });
        inputThread.start();

        for (int i = 0; i < threads.length; i++) {
            Thread thread = threads[i];
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            inputThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}