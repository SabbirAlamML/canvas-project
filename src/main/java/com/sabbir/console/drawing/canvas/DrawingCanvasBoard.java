package com.sabbir.console.drawing.canvas;

import com.sabbir.console.drawing.canvas.shapes.Canvas;
import com.sabbir.console.drawing.canvas.shapes.CanvasBody;
import com.sabbir.console.drawing.canvas.shapes.ShapeFactory;
import com.sabbir.console.drawing.canvas.commands.Command;
import com.sabbir.console.drawing.canvas.commands.CommandFactory;
import com.sabbir.console.drawing.canvas.commands.CreateCommand;
import com.sabbir.console.drawing.canvas.commands.DrawShapeCommand;
import com.sabbir.console.drawing.canvas.commands.QuitCommand;

import java.util.Scanner;

import static java.util.Objects.isNull;

public class DrawingCanvasBoard {

    private static Canvas canvas;
    private static Scanner scanner;
    private static CommandFactory commandFactory;
    private static ShapeFactory shapeFactory;

    public static void main(String[] args) {
        initiate();
    }

    private static void initiate() {
        scanner = new Scanner(System.in);
        commandFactory = new CommandFactory();
        shapeFactory = new ShapeFactory();

        System.out.println("Enter command:");

        while (true) {
            process(scanner.nextLine());
            System.out.println("Enter command:");
        }
    }

    private static void process(String commandLine) {

        Command command = null;
        try {
            command = commandFactory.getCommand(commandLine);
        } catch (IllegalArgumentException e) {
            System.out.println("Command syntax is not correct: " + e.getMessage());
        }

        if (command instanceof QuitCommand)
            quit();

        if (command instanceof CreateCommand) {
            createNewCanvas((CreateCommand) command);
            return;
        }

        if (command instanceof DrawShapeCommand) {
            draw((DrawShapeCommand) command);
        }
    }

    private static void draw(DrawShapeCommand command) {
        if (isNull(canvas)) {
            System.out.println("You need to create a canvas first");
            return;
        }

        try {
            canvas.addShape(shapeFactory.getShape(command));
            System.out.println(canvas.render());

        } catch (IllegalArgumentException e) {
            System.out.println("Can not add the model to canvas: " + e.getMessage());
        }
    }

    private static void createNewCanvas(CreateCommand command) {
        canvas = new CanvasBody(command.getWidth(), command.getHeight());
        System.out.println(canvas.render());
    }

    private static void quit() {
        scanner.close();
        System.out.println("Exiting...");
        System.exit(0);
    }
}
