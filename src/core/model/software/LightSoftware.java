package core.model.software;

public class LightSoftware extends Software {
    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, Type.LIGHT, capacityConsumption, memoryConsumption);
    }

    @Override
    public int getCapacityConsumption() {
        return super.getCapacityConsumption();
    }

    @Override
    public int getMemoryConsumption() {
        return super.getMemoryConsumption();
    }
}
