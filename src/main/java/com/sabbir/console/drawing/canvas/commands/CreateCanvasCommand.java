package com.sabbir.console.drawing.canvas.commands;

import static com.sabbir.console.drawing.canvas.util.ValidationUtility.toPositiveIntNumber;

public class CreateCanvasCommand implements Command {

    private static String helpMessage = "C w h           Should create a new canvas of width w and height h. w, h should be > 0";
    private int height;
    private int width;

    public CreateCanvasCommand(String... params) {

        if (params.length < 2)
            throw new IllegalArgumentException(String.format("Create command expects 2 params.\n%s", helpMessage));

        width = toPositiveIntNumber(params[0]);
        height = toPositiveIntNumber(params[1]);
    }

    public int getHeight() { return height; }

    public CreateCanvasCommand setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getWidth() { return width; }

    public CreateCanvasCommand setWidth(int width) {
        this.width = width;
        return this;
    }
}
