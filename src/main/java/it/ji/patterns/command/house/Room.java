package it.ji.patterns.command.house;

public class Room {
    private String name;
    private boolean lightOn;
    private boolean heatingOn;
    private boolean airConditioningOn;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isLightOn() {
        return lightOn;
    }

    public void setLightOn(boolean lightOn) {
        this.lightOn = lightOn;
    }

    public boolean isHeatingOn() {
        return heatingOn;
    }

    public void setHeatingOn(boolean heatingOn) {
        this.heatingOn = heatingOn;
    }

    public boolean isAirConditioningOn() {
        return airConditioningOn;
    }

    public void setAirConditioningOn(boolean airConditioningOn) {
        this.airConditioningOn = airConditioningOn;
    }

}
