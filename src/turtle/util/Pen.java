package turtle.util;

public enum Pen {

  /**
   * The pen is up
   */
  UP,

  /**
   * The pen is down
   */
  DOWN;

  public Pen opposite() {
    switch (this) {
      case DOWN: return UP;
      case UP:   return DOWN;
    }
    return null;
  }
}
