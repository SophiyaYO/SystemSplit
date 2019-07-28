package core.model.hardware;

import core.model.software.Software;

public class HeavyHardware extends Hardware {
    private int usedCapacity;
    private int usedMemory;

    //TODO extract magic numbers as constants

    public HeavyHardware(String name, int maxCapacity, int maxMemory) {
        super(name, Type.HEAVY, maxCapacity, maxMemory);
    }

    @Override
    public int getMaxCapacity() {
        int baseCapacity = super.getMaxCapacity();

        baseCapacity *= 2;

        return baseCapacity - this.usedCapacity;
    }

    @Override
    public int getMaxMemory() {
        int baseMemory = super.getMaxMemory();

        baseMemory -= baseMemory / 4;

        return baseMemory - this.usedMemory;
    }

    @Override
    protected void setUsedResourses(Software software) {
        this.usedCapacity += software.getCapacityConsumption();
        this.usedMemory += software.getMemoryConsumption();
    }
}
