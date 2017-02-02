package turtle.util;

public enum Direction {

  /**
   * Facing Up
   */
  NORTH,

  /**
   * Facing Up and to the Right
   */
  NORTH_EAST,

  /**
   * Facing to the Right
   */
  EAST,

  /**
   * Facing Down and to the Right
   */
  SOUTH_EAST,

  /**
   * Facing Down
   */
  SOUTH,

  /**
   * Facing Down and to the Left
   */
  SOUTH_WEST,

  /**
   * Facing to the Left
   */
  WEST,

  /**
   * Facing Up and to the left
   */
  NORTH_WEST;

  /**
   * Rotates depending on the received direction
   * @param rotation Says whether it is a rotation to the left of to the right
   * @return return the new direction after the rotation
   */
  public Direction rotate(Rotation rotation) {

    return Direction.values()[(this.ordinal() + rotation.value())
        % Direction.values().length];

  }
}
