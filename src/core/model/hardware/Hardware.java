package core.model.hardware;

import core.model.software.Software;

import java.util.ArrayList;
import java.util.List;

public abstract class Hardware {

    private String name;
    private Type type;
    private int maxCapacity;
    private int maxMemory;
    private List<Software> softwares;

    public Hardware(String name, Type type, int maxCapacity, int maxMemory) {
        this.name = name;
        this.type = type;
        this.maxCapacity = maxCapacity;
        this.maxMemory = maxMemory;
        this.softwares = new ArrayList<>();
    }

    private int getMaxCapacity() {
        return this.maxCapacity;
    }

    private int getMaxMemory() {
        return this.maxMemory;
    }

    public String getName() {
        return this.name;
    }

    public void addSoftware(Software software) {
        if (software.getMemoryConsumption() <= this.getMaxMemory() &&
                software.getCapacityConsumption() <= this.maxCapacity) {
            this.softwares.add(software);
            this.setMaxCapacity(this.maxCapacity - software.getCapacityConsumption());
            this.setMaxCapacity(this.maxMemory - software.getMemoryConsumption());

        }
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    protected enum Type {
        POWER,
        HEAVY
    }
}
