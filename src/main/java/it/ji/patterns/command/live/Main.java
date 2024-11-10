package it.ji.patterns.command.live;

import it.ji.patterns.command.live.actuators.Light;
import it.ji.patterns.command.live.commands.LightCommand;
import it.ji.patterns.command.live.client.Controller;
import it.ji.patterns.command.live.client.House;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Implementeremo una simulazione di una smart home con un sistema di controllo remoto
        //Il telecomando ha 4 pulsanti configurabili e un pulsante per tornare indietro.
        //Le feature che vogliamo ottenere sono:
        // 0. Selettore di stanza, ogni volta che si preme cambia stanza ciclicamente
        // 1. Visualizzare lo stato della smart home
        //    1.1. Visualizzare lo stato delle luci
        //    1.2. Visualizzare lo stato del riscaldamento
        //    1.3. Visualizzare lo stato dell'aria condizionata
        // 2. Accendere e spegnere le luci
        // 3. Accendere e spegnere il riscaldamento
        // 4. Accendere e spegnere l'aria condizionata
        // 5. Possibilità di annullare l'azione precedente.
        // In una prima fase vorremo avere il telecomando con 3 bottoni configurati con le azioni dei punti
        // 2, 3 e 4. Il quarto pulsante non farà niente.
        // In seguito simuleremo l'aggiunta di un nuovo dispositivo e la configurazione del quarto pulsante.
        // Il nuovo dispositivo è un sistema di irrigazione del giardino.

        //Creiamo la smart home
        House smartHome = new House();
        smartHome.addRooms("Soggiorno", "Cucina", "Camera da letto", "Bagno", "Giardino");

        //Creiamo il telecomando
        Controller remoteControl = new Controller(smartHome);
        remoteControl.configureButton(Controller.Buttons.BUTTON_1, new LightCommand(new Light()));

        //Configuriamo il telecomando
        // al momento non possiamo

        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 6) {
            System.out.println("----------- SMART HOME ------------");
            System.out.println("Seleziona l'azione da eseguire:");
            System.out.println("0. Seleziona stanza");
            System.out.println("1. PRESS BUTTON 1");
            System.out.println("2. PRESS BUTTON 2");
            System.out.println("3. PRESS BUTTON 3");
            System.out.println("4. PRESS BUTTON 4");
            System.out.println("5. Annulla l'azione precedente");
            System.out.println("6. Esci");
            System.out.println("-----------------------------------");
            choice = scanner.nextInt();


        }



    }
}
