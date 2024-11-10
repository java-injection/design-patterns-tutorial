package it.ji.patterns.command.wrong1;

public class LuceSalone {
    private boolean accesa;

    public void accendi() {
        accesa = true;
        System.out.println("Luce salone accesa");
    }

    public void spegni() {
        accesa = false;
        System.out.println("Luce salone spenta");
    }

    public boolean isAccesa() {
        return accesa;
    }
}
