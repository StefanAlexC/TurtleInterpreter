package turtle.util;

public enum Rotation {

  /**
   * Rotate anti-clockwise
   */
  LEFT,

  /**
   * Rotate clockwise
   */
  RIGHT;

  /**
   * Used for changing the Direction Enum
   * @return -1 for a rotation to the Left or 1 for a rotation to the right
   */
  public int value() {
    switch (this) {
      case LEFT: return -1;
      case RIGHT: return 1;
    }
    return 0;
  }
}
