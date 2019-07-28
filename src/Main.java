import core.engine.Engine;
import core.inputOutput.reader.ConsoleReader;
import core.inputOutput.reader.Reader;
import core.system.SystemSplit;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();

        SystemSplit systemSplit = new SystemSplit();

        Engine engine = new Engine(systemSplit, reader);

        engine.run();
    }
}
