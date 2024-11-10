package it.ji.patterns.command.wrong;

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
