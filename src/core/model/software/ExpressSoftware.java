package core.model.software;

public class ExpressSoftware extends Software {
    public ExpressSoftware(String name,int capacityConsumption, int memoryConsumption) {
        super(name, Type.EXPRESS, capacityConsumption, memoryConsumption);
    }

    @Override
    public int getCapacityConsumption() {
        return super.getCapacityConsumption();
    }

    @Override
    public int getMemoryConsumption() {
        int baseMemory = super.getMemoryConsumption();
        baseMemory *= 2;
        return baseMemory;
    }
}
