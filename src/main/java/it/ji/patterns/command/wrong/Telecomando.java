package it.ji.patterns.command.wrong1;

import java.util.HashMap;

public class Telecomando {

    private LuceSalone luceSalone = new LuceSalone();
    private SerrandaElettrica serrandaElettrica = new SerrandaElettrica();

    void pressButton1() {
        System.out.println("Button 1 pressed");
        luceSalone.accendi();
    }

    void pressButton2() {
        System.out.println("Button 2 pressed");
        luceSalone.spegni();
        HashMap<String, String> map = new HashMap<>();
    }

    void pressButton3() {
        System.out.println("Button 3 pressed");
        serrandaElettrica.alza();
    }

    void pressButton4() {
        System.out.println("Button 4 pressed");
        serrandaElettrica.abbassa();
    }

}
