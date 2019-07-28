package core;

import core.inputOutput.reader.Reader;
import core.system.SystemSplit;

public class Engine {
    private SystemSplit systemSplit;
    private Reader reader;

    public Engine(SystemSplit systemSplit, Reader reader) {
        this.systemSplit = systemSplit;
        this.reader = reader;
    }

    public void run() {

    }

}
