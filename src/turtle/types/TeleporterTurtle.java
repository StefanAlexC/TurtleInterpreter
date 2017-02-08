package turtle.types;

import java.util.Random;
import turtle.Paper;

public class TeleporterTurtle extends AbstractTurtle {


  /**
   * Constructor for the TeleprterTurtle class
   * @param x X coordinate
   * @param y Y coordinate
   * @param paper Paper on which the turtle moves
   */
  public TeleporterTurtle(int x, int y, Paper paper) {
    super(x, y, paper);
  }

  @Override
  protected void edgeOfPaper() {
    x = new Random().nextInt(paper.getWidth() - 1);
    y = new Random().nextInt(paper.getHeight() - 1);
  }
}
