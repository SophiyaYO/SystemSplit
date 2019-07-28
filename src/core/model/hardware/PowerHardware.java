package core.model.hardware;

import core.model.software.Software;

public class PowerHardware extends Hardware {

    public PowerHardware(String name, int maxCapacity, int maxMemory) {
        super(name, Type.POWER, maxCapacity, maxMemory);
    }

    @Override
    public int getMaxCapacity() {

        int baseCapacity = super.getMaxCapacity();

        baseCapacity -= (baseCapacity * 3) / 4;

        return baseCapacity;
    }

    @Override
    public int getMaxMemory() {

        int baseMemory = super.getMaxMemory();

        baseMemory += (baseMemory * 3) / 4;

        return baseMemory;
    }

    @Override
    protected void setUsedResourses(Software software) {

    }
}
