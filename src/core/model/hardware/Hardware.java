package core.model.hardware;

import core.model.software.Software;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public abstract class Hardware {

    private String name;
    private Type type;
    private int maxCapacity;
    private int maxMemory;
    private List<Software> softwares;
    private int usedCapacity;
    private int usedMemory;

    public Hardware(String name, Type type, int maxCapacity, int maxMemory) {
        this.name = name;
        this.type = type;
        this.maxCapacity = maxCapacity;
        this.maxMemory = maxMemory;
        this.softwares = new ArrayList<>();
        this.usedCapacity = 0;
        this.usedMemory = 0;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public int getMaxMemory() {
        return this.maxMemory;
    }

    public String getName() {
        return this.name;
    }

    public int getSoftwareCount() {
        return this.softwares.size();
    }

    public void addSoftware(Software software) {
        if (software.getMemoryConsumption() <= this.getMaxMemory() &&
                software.getCapacityConsumption() <= this.maxCapacity) {

            this.softwares.add(software);

            this.setUsedResourses(software, (a,b)-> a += b);

        }
    }

    public final int getUsedCapacity() {
        return this.usedCapacity;
    }

    public final int getUsedMemory() {
        return this.usedMemory;
    }

    private void setUsedResourses(Software software, BinaryOperator<Integer> operator){
        this.usedCapacity =  operator.apply(this.usedCapacity, software.getCapacityConsumption());
        this.usedMemory = operator.apply(this.usedMemory, software.getMemoryConsumption());

    }

    public void removeSoftware(String softwareName) {
        Software software = this.softwares
                .stream()
                .filter(s -> s.getName().equalsIgnoreCase(softwareName))
                .findFirst()
                .orElse(null);

        if (software != null) {
            this.softwares
                    .remove(software);

            this.setUsedResourses(software, (a,b) -> a -=b );

        }
    }

    public String  getType() {
        return this.type.name();
    }

    @Override
    public String toString() {
        return this.softwares.size() == 0 ? "None" :
                this.softwares
                        .stream()
                        .map(Software::getName)
                        .collect(Collectors.joining(", "));
    }

    protected enum Type {
        POWER,
        HEAVY
    }
}
