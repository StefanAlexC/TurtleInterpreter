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
    if (x + direction.moveX() < 0) {
      x--;
      direction = direction.reflect(true);
    } else if (x + direction.moveX() == paper.getWidth()){
      x++;
      direction = direction.reflect(true);
    }

    if (y + direction.moveY() < 0 ) {
      y--;
      direction = direction.reflect(false);
    } else if (y + direction.moveY() == paper.getHeight()) {
      y++;
      direction = direction.reflect(false);
    }

    move();
  }
}