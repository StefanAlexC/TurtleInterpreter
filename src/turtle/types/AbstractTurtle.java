package turtle.types;

import turtle.Paper;
import turtle.Turtle;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;
import turtle.util.TurtleType;

public abstract class AbstractTurtle implements Turtle{

  protected int x = 0;
  protected int y = 0;
  protected Direction direction;

  protected TurtleType type;

  protected Pen penState;
  protected char brush = '*';

  protected Paper paper;

  /**
   * Constructor for the Turtle class
   * @param x X coordinate
   * @param y Y coordinate
   * @param paper Paper on which the turtle moves
   */
  public AbstractTurtle(int x, int y, Paper
      paper) {
    this.paper = paper;
    if (paper.inbound(x, y)) {
      this.x = x;
      this.y = y;
      this.direction = Direction.NORTH;
      this.penState = Pen.UP;
    } else {
      System.err.println("Turtle created outside of the assigned paper");
    }
  }

  /**
   * Changes the state of the pen
   */
  public void changePenState(Pen pen) {
    penState = pen;
  }

  /**
   * Changes the brush to a new character;
   */
  public void changeBrush(char newBrush) {
    brush = newBrush;
  }

  /**
   * Marks the current location of the turtle with the brush character
   */
  protected void markCurrentLocation() {
    if (penState == Pen.DOWN)
      paper.markLocation(x, y, brush);
  }

  /**
   * Rotates the turtle in a given direction a given number of times.
   *
   * @param rotation Direction of the rotation
   * @param times Times to rotate
   */
  public void rotate(Rotation rotation, int times) {
    for (int i = 0; i < times; i++) {
      direction = direction.rotate(rotation);
    }
  }

  /**
   * Moves the turtle an integer number of steps in the current direction
   * @param steps The number of steps the turtle moves
   */
  public void moveTurtle(int steps) {
    for (int i = 0; i < steps; i++) {
      if (paper.inbound(x + direction.moveX(), y + direction.moveY())) {
        move();
      } else {
        edgeOfPaper();
      }
      markCurrentLocation();
    }
  }

  /**
   * Determines the behaviour of a Turtle that is on the edge of the
   * paper
   */
  protected abstract void edgeOfPaper();

  /**
   * Moves the turtle in the direction it is currently facing by one step
   */
  protected void move() {
    x += direction.moveX();
    y += direction.moveY();
  }
}
