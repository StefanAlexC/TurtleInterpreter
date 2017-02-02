package turtle;

import turtle.util.Pen;

public class Turtle {

  private int x = 0;
  private int y = 0;
  private Pen penState;
  private char brush = '.';
  private Paper paper;

  /**
   * Constructor for the Turtle class
   * @param x X coordinate
   * @param y Y coordinate
   * @param penState State of the Pen (UP/DOWN)
   * @param paper Paper on which the turtle moves
   */
  public Turtle(int x, int y, Pen penState, Paper paper) {
    this.paper = paper;
    if (paper.inbound(x, y)) {
      this.x = x;
      this.y = y;
      this.penState = penState;
    } else {
      System.err.println("Turtle created outside of the assigned paper");
    }
  }

  /**
   * Changes the state of the pen
   */
  public void changePenState() {
    penState = penState.opposite();
  }

  /**
   * Changes the brush to a new character;
   */
  public void changeBrush(char newBrush) {
    brush = newBrush;
  }





}
