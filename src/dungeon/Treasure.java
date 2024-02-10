package dungeon;

/**
 * An object representing treasure in the dungeon.
 */
public record Treasure(String description, int value) {

  /**
   * Constructor for a Treasure object.
   *
   * @param description the description
   * @param value       the value
   */
  public Treasure {
  }

  /**
   * Accessor for the description.
   *
   * @return the description
   */
  @Override
  public String description() {
    return description;
  }

  /**
   * Accessor for the value.
   *
   * @return the value.
   */
  @Override
  public int value() {
    return value;
  }

  @Override
  public String toString() {
    return String.format("%s (value = %d)", description, value);
  }
}
