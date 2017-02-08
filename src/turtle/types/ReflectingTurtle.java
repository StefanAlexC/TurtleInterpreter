package turtle.types;

import turtle.Paper;
import turtle.util.TurtleType;

public class ReflectingTurtle extends AbstractTurtle{

  /**
   * Constructor for the ReflectingTurtle class
   * @param x X coordinate
   * @param y Y coordinate
   * @param paper Paper on which the turtle moves
   */
  public ReflectingTurtle(int x, int y, Paper paper) {
    super(x, y, paper);
    type = TurtleType.REFLECTING;
  }

  /**
   * Determines the behaviour of a ReflectingTurtle that is on the edge of the
   * paper
   */
  @Override
  protected void edgeOfPaper() {
    //test for corner
    if (x == 0) {
      x--;
      direction = direction.reflect(true);
    } else if (x == paper.getWidth() - 1){
      x++;
      direction = direction.reflect(true);
    }

    if (y == 0 ) {
      y--;
      direction = direction.reflect(false);
    } else if (y == paper.getHeight() - 1) {
      y++;
      direction = direction.reflect(false);
    }

    move();
  }
}