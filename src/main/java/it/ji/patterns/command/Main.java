package it.ji.patterns.command;

import it.ji.patterns.command.house.House;

public class Main {
    public static void main(String[] args) {

        //Implementeremo una simulazione di una smart home con un sistema di controllo remoto
        //Il telecomando ha 4 pulsanti configurabili e un pulsante per tornare indietro.
        //Le feature che vogliamo ottenere sono:
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


    }
}
