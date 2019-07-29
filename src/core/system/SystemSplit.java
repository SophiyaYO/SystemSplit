package core.system;

import core.model.hardware.Hardware;
import core.model.software.Software;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

public class SystemSplit {

    private Map<String, Hardware> hardwareComponents;

    public SystemSplit() {
        this.hardwareComponents = new LinkedHashMap<>();
    }

    public void addHardwareComponent(Hardware hardware) {
        this.hardwareComponents.put(hardware.getName(), hardware);
    }

    public void addSoftwareToHardware(String hardwareName, Software software) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            Hardware hardware = this.hardwareComponents.get(hardwareName);
            hardware.addSoftware(software);

        }
    }

    public void releaseSoftware(String hardwareName, String softwareName) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            Hardware hardware = this.hardwareComponents.get(hardwareName);
            hardware.removeSoftware(softwareName);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        this.hardwareComponents.values().stream()
                .sorted((f, s) -> {
                    if (f.getType().equalsIgnoreCase("Power")) {
                        return -1;
                    } else {
                        return 1;
                    }
                })
                .forEach(h -> builder
                        .append(h.toString())
                        .append(System.lineSeparator()));

        return builder.toString().trim();
    }

    public int getHardwareComponentSize() {
        return this.hardwareComponents.size();
    }

    public int getSoftwareComponentCount() {
        return this.getSumValue(Hardware::getSoftwareCount);
    }

    public int getTotalOperationalMemoryInUse() {
        return this.getSumValue(Hardware::getUsedMemory);
    }

    public int getTotalCapacityTaken() {
        return this.getSumValue(Hardware::getUsedCapacity);
    }

    public int getMaximumMemory() {
        return this.getSumValue(Hardware::getMaxMemory);
    }

    public int getMaximumCapacity() {
        return this.getSumValue(Hardware::getMaxCapacity);
    }

    private int getSumValue(ToIntFunction<Hardware> function) {
        return this.hardwareComponents
                .values()
                .stream()
                .mapToInt(function)
                .sum();
    }


}
