class ContoBancario {
    private double saldo;

    public ContoBancario(double saldoIniziale) {
        this.saldo = saldoIniziale;
    }

    public synchronized void deposito(double importo) {
        saldo += importo;
        stampaOutput("--- ha depositato: $" + String.format("%.2f", importo) + " --- Saldo attuale: $" + String.format("%.2f", saldo));
    }

    public synchronized void prelievo(double importo) {
        if (saldo >= importo) {
            saldo -= importo;
            stampaOutput("--- ha prelevato: $" + String.format("%.2f", importo) + " --- Saldo attuale: $" + String.format("%.2f", saldo));
        } else {
            stampaOutput("Non ci sono fondi sufficienti per il prelievo di: $" + String.format("%.2f", importo));
        }
    }

    public synchronized double getSaldo() {
        return saldo;
    }

    private void stampaOutput(String messaggio) {
        System.out.println(Thread.currentThread().getName() + " " + messaggio);
        pausa();
    }

    private void pausa() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

