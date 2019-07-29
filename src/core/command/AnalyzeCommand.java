package core.command;

import core.system.SystemSplit;

public class AnalyzeCommand extends BaseCommand {
    private SystemSplit systemSplit;

    public AnalyzeCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
    }

    @Override
    public void execute() {

        StringBuilder builder = new StringBuilder();

        int hardwareComponentsCount = this.systemSplit.getHardwareComponentSize();
        int softwareComponentsCount = this.systemSplit.getSoftwareComponentCount();

        int totalMemoryInUsed = this.systemSplit.getTotalOperationalMemoryInUse();
        int totalCapacityTaken = this.systemSplit.getTotalCapacityTaken();

        int maxMemory = this.systemSplit.getMaximumMemory() + totalMemoryInUsed;
        int maxCapacity = this.systemSplit.getMaximumCapacity() + totalCapacityTaken;

        builder.append("System Analysis")
                .append(System.lineSeparator())
                .append(String.format(
                        "Hardware Components: %d",
                        hardwareComponentsCount))
                .append(System.lineSeparator())
                .append(String.format(
                        "Software Components: %d",
                        softwareComponentsCount))
                .append(System.lineSeparator())
                .append(String.format("Total Operational Memory: %d / %d",
                        totalMemoryInUsed,
                        maxMemory))
                .append(System.lineSeparator())
                .append(String.format("Total Capacity Taken: %d / %d",
                        totalCapacityTaken,
                        maxCapacity));

        System.out.println(builder.toString().trim());

    }
}
//"Hardware Component – {componentName}
//        Express Software Components - {countOfExpressSoftwareComponents}
//        Light Software Components - {countOfLightSoftwareComponents}
//        Memory Usage: {memoryUsed} / {maximumMemory}
//        Capacity Usage: {capacityUsed} / {maximumCapacity}
//        Type: {Power/Heavy}
//        Software Components: {softwareComponent1, softwareComponent2…}"


