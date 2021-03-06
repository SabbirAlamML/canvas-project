package com.sabbir.console.drawing.canvas.commands;

import java.util.Arrays;

public class CommandFactory {

    public Command getCommand(String commandLine) {

        commandLine = commandLine.trim().replaceAll(" {2}", " ");

        final String[] split   = commandLine.split(" ");
        final String   command = split[0].toUpperCase();
        final String[] params  = Arrays.copyOfRange(split, 1, split.length);

        switch (command) {
            case "C": return new CreateCanvasCommand(params);
            case "L": return new DrawLineCommand(params);
            case "R": return new DrawRectangleCommand(params);
            case "B": return new BucketFillCommand(params);
            case "Q": return new QuitCommand();
            default: throw new IllegalArgumentException(String.format("Invalid command %s", command));
        }

    }
}
