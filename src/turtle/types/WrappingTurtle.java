package turtle.types;

import turtle.Paper;
import turtle.util.TurtleType;

public class WrappingTurtle extends AbstractTurtle {

  /**
   * Constructor for the WrappingTurtle class
   * @param x X coordinate
   * @param y Y coordinate
   * @param paper Paper on which the turtle moves
   */
  public WrappingTurtle(int x, int y, Paper paper) {
    super(x, y, paper);
    type = TurtleType.WRAPPING;
  }

  /**
   * Determines the behaviour of a WrappingTurtle that is on the edge of the
   * paper
   */
  @Override
  protected void edgeOfPaper() {
    move();
    x = (x + paper.getWidth()) % paper.getWidth();
    y = (y + paper.getHeight()) % paper.getHeight();
  }
}
