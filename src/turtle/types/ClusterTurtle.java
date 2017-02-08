package turtle.types;

import java.util.List;
import turtle.Turtle;
import turtle.util.Pen;
import turtle.util.Rotation;

public class ClusterTurtle implements Turtle {

  List<Turtle> turtles;

  /**
   * Default constructor for a cluster of turtles
   * @param turtles Recieves a list that contains all the turtles that make
   * up this cluster
   */
  public ClusterTurtle(List<Turtle> turtles) {
    this.turtles = turtles;
  }

  /**
   * Changes the pen state for the whole cluster
   * @param pen The new pen state
   */
  @Override
  public void changePenState(Pen pen) {
    for (Turtle turtle : turtles) {
      turtle.changePenState(pen);
    }
  }

  /**
   * Changes the brush character for the whole cluster of turtles
   * @param newBrush The new brush character
   */
  @Override
  public void changeBrush(char newBrush) {
    for (Turtle turtle : turtles) {
      turtle.changeBrush(newBrush);
    }
  }

  /**
   * Rotates the whole cluster of turtles
   * @param rotation The direction of the rotation
   * @param times The number of times the turtle rotates
   */
  @Override
  public void rotate(Rotation rotation, int times) {
    for (Turtle turtle : turtles) {
      turtle.rotate(rotation, times);
    }
  }

  /**
   * Moves the whole cluster of turtles
   * @param steps The number of steps the turtle moves
   */
  @Override
  public void moveTurtle(int steps) {
    for (Turtle turtle : turtles) {
      turtle.moveTurtle(steps);
    }
  }
}
