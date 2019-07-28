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

    }
}
//"Hardware Component – {componentName}
//        Express Software Components - {countOfExpressSoftwareComponents}
//        Light Software Components - {countOfLightSoftwareComponents}
//        Memory Usage: {memoryUsed} / {maximumMemory}
//        Capacity Usage: {capacityUsed} / {maximumCapacity}
//        Type: {Power/Heavy}
//        Software Components: {softwareComponent1, softwareComponent2…}"
