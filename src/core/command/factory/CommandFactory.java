package core.command.factory;

import core.command.Command;

public class CommandFactory {
    private static final String BASE_COMMAND_PACkAGE = "core.command.";
    private static final String COMMAND_SUFFIX = "Command";

    public Command buildCommand(String name, Object... args) {

        try {
            Class commandClass = Class.forName(BASE_COMMAND_PACkAGE);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}

