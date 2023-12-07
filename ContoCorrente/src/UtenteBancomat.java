import java.util.Random;

class UtenteBancomat implements Runnable {
    private ContoBancario contoBancario;
    private Random random = new Random();

    public UtenteBancomat(ContoBancario contoBancario) {
        this.contoBancario = contoBancario;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            double importo = random.nextDouble() * 100;
            if (random.nextBoolean()) {
                contoBancario.deposito(importo);
            } else {
                contoBancario.prelievo(importo);
            }
        }
    }
}