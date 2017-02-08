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

  /**
   * Returns the opposite state of the state the pen is currently in
   * @return The appropriate pen state
   */
  public Pen opposite() {
    switch (this) {
      case DOWN: return UP;
      case UP:   return DOWN;
    }
    return null;
  }

  /**
   * Converts the parameter of the pen turtle command into a Pen Enum
   * @param input The third parameter of the pen command
   * @return The appropriate pen state(Up / Down)
   */
  public static Pen parseInput(String input) {
    switch (input) {
      case "up": return UP;
      case "down": return DOWN;
      default:
        System.err.println("Invalid Pen Input");
        return null;
    }
  }
}
