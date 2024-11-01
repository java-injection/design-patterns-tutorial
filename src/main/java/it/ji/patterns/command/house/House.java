package it.ji.patterns.command.house;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class House {

    private List<Room> rooms = new ArrayList<>();


    public House addRoom(String roomName) {
        rooms.add(new Room(roomName));
        return this;
    }

    public List<Room> getRooms() {
        return rooms;
    }


}
