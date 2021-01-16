# Console-drawing
This is Console Java program

# Software used for development are
1. Intellij
2. Maven
3. Java 8
4. Collections

# Known issues
Please run this program in Eclipse/Intellij/NetBeans

# Steps
* Clone the repository https://github.com/SabbirAlamML/canvas-project.git
* Import in Intellij/Eclipse/NetBeans
* Maven build = mvn clean install
* Run com.console.DrawingCanvasBoard.java from IDE


# Usage
  Command        | Description
  -------------  |---------------------------------------------
  C w h          | Create a new canvas of width w and height h.
  L x1 y1 x2 y2  | Create a new line of 'x' from (x1,y1) to (x2,y2). Only support horizontal or vertical lines.
  R x1 y1 x2 y2  | Create a new rectangle, (x1,y1) is upper left corner & (x2,y2) is lower right corner.
  B x y c        | Fill the entire area around (x,y) with "colour" c. Color can be any one of these ["r", "b", "y", "g", "c", "p"].
  Q              | Quit.

 # Main class
 com.console.DrawingCanvasBoard.java
