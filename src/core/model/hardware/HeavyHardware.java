package core.model.hardware;

public class HeavyHardware extends Hardware {

    public HeavyHardware(String name, int maxCapacity, int maxMemory) {
        super(name, Type.HEAVY, maxCapacity, maxMemory);
    }

    @Override
    public int getMaxCapacity() {
        int baseCapacity = super.getMaxCapacity();

        baseCapacity *= 2;

        return baseCapacity;
    }

    @Override
    public int getMaxMemory() {
        int baseMemory = super.getMaxMemory();

        baseMemory -= baseMemory / 4;

        return baseMemory;
    }
}
