package turtle.util;

public enum Commands {

  /**
   * Paper command
   */
  PAPER,

  /**
   * NewTurtle command
   */
  NEW,

  /**
   * Pen command
   */
  PEN,

  /**
   * Move command
   */
  MOVE,

  /**
   * RightRotation command
   */
  RIGHT,

  /**
   * LeftRotation Command
   */
  LEFT,

  /**
   * ShowPaper Command
   */
  SHOW;

  /**
   * Converts the turtle command key word to a Commands Enum
   * @param command The string version of the turtle command keyword
   * @return The appropriate Commands Enum
   */
  public static Commands parseInput(String command) {
    switch (command) {
      case "paper":
        return PAPER;
      case "new":
        return NEW;
      case "pen":
        return PEN;
      case "move":
        return MOVE;
      case "right":
        return RIGHT;
      case "show":
        return SHOW;
      case "left":
        return LEFT;
      default:
        System.err.println("Invalid Command Input");
        return null;
    }
  }
}
