package core.system;

import core.model.hardware.Hardware;
import core.model.software.Software;

import java.util.HashMap;
import java.util.Map;

public class SystemSplit {

    private Map<String , Hardware> hardwareComponents;

    public SystemSplit() {
        this.hardwareComponents = new HashMap<>();
    }

    public void addHardwareComponent(Hardware hardware) {
        this.hardwareComponents.put(hardware.getName(), hardware);
    }

    public void addSoftwareToHardware(String hardwareName, Software software) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            Hardware hardware = this.hardwareComponents.get(hardwareName);
            hardware.addSoftware(software);
            System.out.println(hardware.getMaxCapacity());
            System.out.println(hardware.getMaxMemory());
        }
    }

    public int getHardwareComponentSize(){
        return this.hardwareComponents.size();
    }

    public int getSoftwareComponentCount(){
        return this.hardwareComponents.values().stream()
                .mapToInt(Hardware::getSoftwareCount)
                .sum();
    }

    public int getTotalOperationalMemoryInUse() {
       return this.hardwareComponents.values()
                .stream()
                .mapToInt(Hardware::getUsedMemory)
                .sum();
    }

    public int getTotalCapacityTaken(){
        return this.hardwareComponents.values()
                .stream()
                .mapToInt(Hardware::getUsedCapacity)
                .sum();
    }
}
