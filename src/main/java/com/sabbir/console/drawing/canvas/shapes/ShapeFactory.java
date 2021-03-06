package com.sabbir.console.drawing.canvas.shapes;

import com.sabbir.console.drawing.canvas.commands.BucketFillCommand;
import com.sabbir.console.drawing.canvas.commands.DrawLineCommand;
import com.sabbir.console.drawing.canvas.commands.DrawRectangleCommand;
import com.sabbir.console.drawing.canvas.commands.DrawShapeCommand;

public class    ShapeFactory {

    public Shape getShape(DrawShapeCommand command) {

        if (command instanceof DrawLineCommand)
            return createLine((DrawLineCommand) command);

        else if (command instanceof DrawRectangleCommand)
            return createRectangle((DrawRectangleCommand) command);

        else if (command instanceof BucketFillCommand)
            return createBucketFill((BucketFillCommand) command);

        return null;
    }

    private Line createLine(DrawLineCommand cmd) {
        return new Line(cmd.getX1(), cmd.getY1(),
                        cmd.getX2(), cmd.getY2());
    }

    private Rectangle createRectangle(DrawRectangleCommand cmd) {
        return new Rectangle(cmd.getX1(), cmd.getY1(),
                cmd.getX2(), cmd.getY2());
    }

    private BucketFill createBucketFill(BucketFillCommand cmd) {
        return new BucketFill(cmd.getX(), cmd.getY(),
                                cmd.getColor());
    }
}
