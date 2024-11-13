package it.ji.patterns.observer.live;

public interface GuiListener {

    // creo l'interfaccia i cui metodi rappresentano gli eventi
    // che devo trattare

    void clickedButton(int buttonNumber);

    void sendCommand(String command);
}
