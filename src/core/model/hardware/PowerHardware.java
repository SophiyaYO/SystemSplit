package core.model.hardware;

public class PowerHardware extends Hardware {

    public PowerHardware(String name, int maxCapacity, int maxMemory) {
        super(name, Type.POWER, maxCapacity, maxMemory);
    }
}
