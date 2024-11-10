package it.ji.patterns.command.wrong1;

public class SerrandaElettrica {

    private boolean aperta;

    public void alza() {
        aperta = true;
        System.out.println("Serranda alzata");
    }

    public void abbassa() {
        aperta = false;
        System.out.println("Serranda abbassata");
    }

    public boolean isAperta() {
        return aperta;
    }
}
