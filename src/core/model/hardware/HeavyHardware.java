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
        long expressSoftwareCount = this.getSoftwares()
                .stream()
                .filter(s -> s.getClass()
                        .getSimpleName()
                        .equals("ExpressSoftware"))
                .count();

        return String.format("Hardware Component – %s%n" +
                        "Express Software Components - %d%n" +
                        "Light Software Components - %d%n" +
                        "Memory Usage: %d / %d%n" +
                        "Capacity Usage: %d / %d%n" +
                        "Type: %s%n" +
                        "Software Components: %s",
                this.getName(),
                expressSoftwareCount,
                (this.getSoftwares().size() - expressSoftwareCount),
                this.getUsedMemory(),
                this.getMaxMemory() + this.getUsedMemory(),
                this.getUsedCapacity(),
                this.getUsedCapacity() + this.getMaxCapacity(),
                this.getType().compareTo(Type.HEAVY.name()) == 0 ? "Heavy" : "Power",
                super.toString());

    }
}
