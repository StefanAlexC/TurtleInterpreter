package turtle.types;

import turtle.Paper;
import turtle.util.TurtleType;

public class NormalTurtle extends AbstractTurtle{


  /**
   * Constructor for the NormalTurtle class
   * @param x X coordinate
   * @param y Y coordinate
   * @param paper Paper on which the turtle moves
   */
  public NormalTurtle(int x, int y, Paper paper) {
    super(x, y, paper);
    type = TurtleType.NORMAL;
  }
  /**
   * Determines the behaviour of a NormalTurtle that is on the edge of the
   * paper
   */
  @Override
  protected void edgeOfPaper() {
  }


}
