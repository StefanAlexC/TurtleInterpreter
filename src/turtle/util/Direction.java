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

    return Direction.values()[(this.ordinal() + rotation.value() + Direction
        .values().length)
        % (Direction.values().length)];

  }

  /**
   * Computes the change on the X axis depending on the direction
   *
   * @return returns the change on the X axis
   */
  public int moveY() {
    switch (this) {
      case NORTH:
      case NORTH_WEST:
      case NORTH_EAST:
        return 1;
      case WEST:
      case EAST:
        return 0;
      default:
        return -1;
    }
  }

  /**
   * Computes the change on the Y axis depending on the direction
   *
   * @return returns the change on the Y axis
   */
  public int moveX() {
    switch (this) {
      case NORTH:
      case SOUTH:
        return 0;
      case NORTH_EAST:
      case EAST:
      case SOUTH_EAST:
        return 1;
      default:
        return -1;
    }
  }

  /**
   * Computes the new direction after a bounce
   * @return Returns the new direction
   */
  public Direction bounceBack() {
    switch (this) {
      case NORTH: return SOUTH;
      case SOUTH: return NORTH;
      case EAST:  return WEST;
      case WEST:  return EAST;
      case NORTH_EAST: return SOUTH_WEST;
      case NORTH_WEST: return SOUTH_EAST;
      case SOUTH_EAST: return NORTH_WEST;
      case SOUTH_WEST: return NORTH_EAST;
    }
    return null;
  }

  /**
   * Computes the new direction after a reflection
   * @param LateralReflection Says whether or not the collision was with the
   * side of the paper
   * @return Returns the new direction
   */
  public Direction reflect(boolean LateralReflection) {
    switch (this) {
      case NORTH: return SOUTH;
      case SOUTH: return NORTH;
      case EAST:  return WEST;
      case WEST:  return EAST;
      case SOUTH_WEST: return LateralReflection ? SOUTH_EAST : NORTH_WEST;
      case SOUTH_EAST: return LateralReflection ? SOUTH_WEST : NORTH_EAST;
      case NORTH_WEST: return LateralReflection ? NORTH_EAST : SOUTH_WEST;
      case NORTH_EAST: return LateralReflection ? NORTH_WEST : SOUTH_EAST;
    }
    return null;
  }
}
