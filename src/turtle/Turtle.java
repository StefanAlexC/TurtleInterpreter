package turtle;

import turtle.util.Pen;
import turtle.util.Rotation;

public interface Turtle {

  /**
   * Changes the pen state
   * @param pen The new pen state
   */
 public void changePenState(Pen pen);

  /**
   * Changes the brush of the turtle
   * @param newBrush The new brush character
   */
 public void changeBrush(char newBrush);

  /**
   * Rotates the turtle
   * @param rotation The direction of the rotation
   * @param times The number of times the turtle rotates
   */
 public void rotate(Rotation rotation, int times);

  /**
   * Moves the turtle
   * @param steps The number of steps the turtle moves
   */
 public void moveTurtle(int steps);

}
