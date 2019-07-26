package core.model.hardware;

public abstract class Hardware {

    private String name;
    private Type type;
    private int maxCapacity;
    private int maxMemory;

    public Hardware(String name, Type type, int maxCapacity, int maxMemory) {
        this.name = name;
        this.type = type;
        this.maxCapacity = maxCapacity;
        this.maxMemory = maxMemory;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public int getMaxMemory() {
        return this.maxMemory;
    }

    protected enum Type {
        POWER,
        HEAVY
    }
}
