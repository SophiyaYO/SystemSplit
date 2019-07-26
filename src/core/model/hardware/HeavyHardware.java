package core.model.hardware;

public class HeavyHardware extends  Hardware {

    public HeavyHardware(String name, int maxCapacity, int maxMemory) {
        super(name, Type.HEAVY, maxCapacity, maxMemory);
    }
}
