package turtle;

import java.lang.reflect.Array;

public class Paper {

  private final int width;
  private final int height;
  private char[][] paper;

  /**
   * Constructor for Paper object
   * @param width width of the paper
   * @param height height of the paper
   */
  public Paper(int width, int height) {
    this.width = width;
    this.height = height;
    paper = new char[width][height];
    initialisePaper();
  }

  /**
   * Width getter
   * @return width of the paper
   */
  public int getWidth() {
    return width;
  }

  /**
   * Height getter
   * @return height of the paper
   */
  public int getHeight() {
    return height;
  }

  /**
   * Check if the given coordinates are contained by the paper
   * @param x X coordinate
   * @param y Y coordinate
   * @return true if the point is contained or false if otherwise
   */
  public boolean inbound(int x, int y) {
    return (0 <= x && x < width) &&
        (0 <= y && y < height);
  }

  /**
   * Marks the specified location with given character
   * @param x X coordinate
   * @param y Y coordinate
   * @param symbol symbol drawn by the turtle pen
   */
  public void markLocation(int x, int y, char symbol) {
    if (this.inbound(x, y)) {
      paper[x][y] = symbol;
    }
  }

  /**
   * Initialises the paper with the space character
   */
  private void initialisePaper() {
    for (int i = 0 ; i < width ; i++)
      for (int j = 0 ; j < height ; j++)
        paper[i][j] = ' ';
  }

  /**
   * toString method for the Paper Class
   * @return String representation of a Paper object
   */
  @Override
  public String toString() {
    String output = "";

    for (int j = height - 1 ; j >= 0 ; j--) {
      for (int i = 0 ; i < width ; i++) {
        output += paper[i][j];
      }
      output += "\n";
    }

    return output;
  }

}
