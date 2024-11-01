package it.ji.patterns.command.house;

public class Controller {
    private House home;

    public Controller(House home) {
        this.home = home;
    }

    public void nextRoom(){

    }

    public void button1Pressed() {
        System.out.println("Button 1 pressed");
    }

    public void button2Pressed() {
        System.out.println("Button 2 pressed");
    }

    public void button3Pressed() {
        System.out.println("Button 3 pressed");
    }

    public void button4Pressed() {
        System.out.println("Button 4 pressed");
    }


    public void undo() {
    }
}
