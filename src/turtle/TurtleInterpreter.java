package turtle;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import turtle.types.*;
import turtle.util.Commands;
import turtle.util.Pen;
import turtle.util.Rotation;

public class TurtleInterpreter {

  private Scanner input;
  private PrintStream output;
  private Paper paper;
  private Map<String, Turtle> turtleMap;

  private final int DEFAULT_PAPER_SIZE = 10;

  /**
   * Constructor for TurtleInterpreter object
   * @param input Input Scanner
   * @param output Output PrintStream
   */
  public TurtleInterpreter(Scanner input, PrintStream output) {
    this.input = input;
    this.output = output;
    paper = new Paper(DEFAULT_PAPER_SIZE, DEFAULT_PAPER_SIZE);
    turtleMap = new HashMap<>();
  }

  /**
   * Processes all the turtle commands in the given file
   */
  public void processCommands() {

    while (input.hasNext()) {
      nextCommand();
    }

  }

  /**
   * Calls the appropriate command depending on the keyword given
   */
  public void nextCommand() {

    Commands command = Commands.parseInput(input.next());

    switch (command) {
      case PAPER:
        paperCommand(); break;
      case NEW:
        newTurtleCommand(""); break;
      case PEN:
        penCommand(); break;
      case MOVE:
        moveCommand(); break;
      case RIGHT:
        rotateCommand(Rotation.RIGHT); break;
      case LEFT:
        rotateCommand(Rotation.LEFT); break;
      case SHOW:
        showCommand(); break;
    }

  }

  /**
   * Processes the show command
   */
  private void showCommand() {
    output.println(paper);
  }

  /**
   * Processes the rotation command
   * right: turtle_name angle
   * left: turtle_name angle
   * @param rotationDirection Names the direction in which the turtle rotates
   */
  private void rotateCommand(Rotation rotationDirection) {
    String turtleName = input.next();
    int times = input.nextInt() / 45;
    turtleMap.get(turtleName).rotate(rotationDirection, times);
  }

  /**
   * Process the move command
   * move: turtle_name distance
   */
  private void moveCommand() {
    String turtleName = input.next();
    int steps = input.nextInt();
    turtleMap.get(turtleName).moveTurtle(steps);
    System.out.println(paper);
  }

  /**
   * Process the pen command
   * pen: turtle_name state(up / down / single char)
   */
  private void penCommand() {
    String turtleName = input.next();
    String penState = input.next();
    if (penState.length() > 1) {
      turtleMap.get(turtleName).changePenState(Pen.parseInput(penState));
    } else if (penState.length() == 1 && nonBlank(penState.charAt(0))) {
      turtleMap.get(turtleName).changeBrush(penState.charAt(0));
    }
  }

  /**
   * Process the newTurtle command
   * new: type turtle_name x y
   */
  private Turtle newTurtleCommand(String nameHeader) {
    String type = input.next();
    String turtleName = nameHeader + input.next();
    Turtle temp;

    if (type.equals("cluster")) {
      temp = new ClusterTurtle(clusterCreator(turtleName));
      turtleMap.put(turtleName, temp);
    }
    else {
      int x = input.nextInt();
      int y = input.nextInt();
      temp = createTurtle(type, x, y, paper);
      turtleMap.put(turtleName, temp);
    }

    return temp;
  }

  /**
   * Creates the appropriate turtle
   * @param type The type of the new turtle
   * @param x The x coordinate of the turtle
   * @param y The y coordinate of the turtle
   * @param paper The paper on which the turtle is created
   * @return The new instance of the turtle
   */
  private Turtle createTurtle(String type, int x, int y, Paper paper) {
    switch (type) {
      case "normal": return new NormalTurtle(x, y, paper);
      case "continuous": return new ContinuousTurtle(x, y, paper);
      case "bouncy": return new BouncyTurtle(x, y, paper);
      case "reflecting": return new ReflectingTurtle(x, y, paper);
      case "wrapping": return new WrappingTurtle(x, y, paper);
      default:
        System.err.println("Invalid turtle type");
    }
    return null;
  }

  /**
   * Creates a cluster of turtles and reads all the turtles contained by
   * this cluster
   * @param name The name of the cluster of turtles
   * @return The list containing all the turtles that make up this cluster
   */
  private List<Turtle> clusterCreator(String name) {
    List<Turtle> turtles = new LinkedList<>();
    int numberOfTurtles = input.nextInt();

    for (int i = 0 ; i < numberOfTurtles ; i++) {
      input.next();
      turtles.add(newTurtleCommand(name + "."));
    }

    return turtles;
  }

  /**
   * Process the paperCommand
   * paper: width height
   */
  private void paperCommand() {
    int width = input.nextInt();
    int height = input.nextInt();
    paper = new Paper(width, height);
    turtleMap = new HashMap<>();
  }

  /**
   * Check if the given character is non-blank
   * @param c The character to be checked
   * @return Returns true if the char is non-blank and false otherwise
   */
  private boolean nonBlank(char c) {
    return c != ' ';
  }
}
