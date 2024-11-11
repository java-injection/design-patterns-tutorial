package it.ji.patterns.state.live;

public class Main {

    //Come implementare uno State Pattern
    //1. Creare una tabella degli stati, in modo da avere nelle righe gli stati e nelle colonne le azioni
    //2. Creare la classe che dovrà cambiare lo stato (nel nostro esempio il Task)
    //3. Creare un interfaccia State con tanti metodi per quante sono le azioni (passando il Task come parametro)
    //4. Creare una classe per ogni stato che implementi l'interfaccia State
    //5. Implementare i metodi delle classi degli stati in modo che possano cambiare lo stato del Task
    //6. Implementare i metodi del Task in modo che chiamino i metodi dello stato corrente
    public static void main(String[] args) {
        Task task = new Task("Develop Feature X");

        System.out.println("Current State: " + task.getStateName()); // TODO
        task.startWorking();  // Passa a IN PROGRESS
        System.out.println("Current State: " + task.getStateName()); // IN PROGRESS

        task.startTesting();  // Passa a TESTING
        System.out.println("Current State: " + task.getStateName()); // TESTING

        task.testFailed();    // Torna a IN PROGRESS
        System.out.println("Current State: " + task.getStateName()); // IN PROGRESS

        task.startTesting();  // Torna a TESTING
        System.out.println("Current State: " + task.getStateName()); // TESTING

        task.testPassed();    // Passa a DONE
        System.out.println("Current State: " + task.getStateName()); //
    }
}
