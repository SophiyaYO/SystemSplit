package core.model.hardware;

public class HeavyHardware extends Hardware {


    //TODO extract magic numbers as constants

    public HeavyHardware(String name, int maxCapacity, int maxMemory) {
        super(name, Type.HEAVY, maxCapacity, maxMemory);

    }

    @Override
    public int getMaxCapacity() {
        int baseCapacity = super.getMaxCapacity();

        baseCapacity *= 2;

        return baseCapacity - super.getUsedCapacity();
    }

    @Override
    public int getMaxMemory() {
        int baseMemory = super.getMaxMemory();

        baseMemory -= baseMemory / 4;

        return baseMemory - super.getUsedMemory();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
