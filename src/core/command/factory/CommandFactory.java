package core.command.factory;

import core.command.Command;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandFactory {
    private static final String BASE_COMMAND_PACkAGE = "core.command.";
    private static final String COMMAND_SUFFIX = "Command";

    @SuppressWarnings("unchecked")
    public Command buildCommand(String name, Object... args) {

        try {
            Class commandClass = Class.forName(BASE_COMMAND_PACkAGE);
            Constructor<Command> constructor = commandClass.getDeclaredConstructors()[0];
           return constructor.newInstance(args);
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

}

