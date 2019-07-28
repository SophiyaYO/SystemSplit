package core.model.hardware;

import core.model.software.Software;

public class PowerHardware extends Hardware {

    private int usedCapacity;
    private int usedMemory;

    public PowerHardware(String name, int maxCapacity, int maxMemory) {
        super(name, Type.POWER, maxCapacity, maxMemory);
        this.usedCapacity = 0;
        this.usedMemory = 0;
    }

    @Override
    public int getMaxCapacity() {

        int baseCapacity = super.getMaxCapacity();

        baseCapacity -= (baseCapacity * 3) / 4;

        return baseCapacity - this.usedCapacity;
    }

    @Override
    public int getMaxMemory() {

        int baseMemory = super.getMaxMemory();

        baseMemory += (baseMemory * 3) / 4;

        return baseMemory - this.usedMemory;
    }

    @Override
    protected void setUsedResourses(Software software) {
        this.usedCapacity += software.getCapacityConsumption();
        this.usedMemory += software.getMemoryConsumption();
    }
}
