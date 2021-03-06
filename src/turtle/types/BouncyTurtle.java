package turtle.types;

import turtle.Paper;

public class BouncyTurtle extends AbstractTurtle{


  /**
   * Constructor for the BouncyTurtle class
   * @param x X coordinate
   * @param y Y coordinate
   * @param paper Paper on which the turtle moves
   */
  public BouncyTurtle(int x, int y, Paper paper) {
    super(x, y, paper);
  }

  /**
   * Determines the behaviour of a BouncyTurtle that is on the edge of the
   * paper
   */
  @Override
  protected void edgeOfPaper() {
    direction = direction.bounceBack();
  }
}
