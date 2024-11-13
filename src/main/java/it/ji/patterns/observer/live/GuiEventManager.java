package it.ji.patterns.observer.live;

import java.util.LinkedList;
import java.util.List;

public class GuiEventManager {

    // mi faccio una classe dispatcher che sia singleton
    // faccio una lista di listeners
    // predispongo i metodi pubblici per registrarsi al broker (inserirsi alla lista)
    // creo tanti metodi quanti sono i metodi dell'interfaccia listener e al loro
    // interno dispatcho l'evento omonimo (col forEach(...))

    private static GuiEventManager instance = null;

    private List<GuiListener> guiListeners = new LinkedList<>();

    private GuiEventManager() {

    }

    public static GuiEventManager getInstance() {
        if(instance == null) {
            instance = new GuiEventManager();
        }
        return instance;
    }

    public void addGuiListener(GuiListener guiListener) {
        this.guiListeners.add(guiListener);
    }

    public void removeGuiListener(GuiListener guiListener) {
        this.guiListeners.remove(guiListener);
    }

    public void clickedButton(int buttonNumber) {
        this.guiListeners.forEach(guiListener -> guiListener.clickedButton(buttonNumber));
    }

    public void sendCommand(String command) {
        this.guiListeners.forEach(guiListener -> guiListener.sendCommand(command));
    }



}
