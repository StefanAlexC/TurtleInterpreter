package turtle.types;

import turtle.Paper;
import turtle.util.TurtleType;

public class ContinuousTurtle extends AbstractTurtle{


  /**
   * Constructor for the ContinuousTurtle class
   * @param x X coordinate
   * @param y Y coordinate
   * @param paper Paper on which the turtle moves
   */
  public ContinuousTurtle(int x, int y, Paper paper) {
    super(x, y, paper);
    type = TurtleType.CONTINUOUS;
  }

  /**
   * Determines the behaviour of a ContinuousTurtle that is on the edge of the
   * paper
   */
  @Override
  protected void edgeOfPaper() {
    move();
  }
}
