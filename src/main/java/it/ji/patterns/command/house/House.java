package it.ji.patterns.command.house;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class House {

    private List<Room> rooms = new ArrayList<>();


    public void addRooms(String ... roomName) {
        for (String name : roomName) {
            rooms.add(new Room(name));
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }


}
