package Characters

import Armas.Weapon
import TurnScheduler.ActionBar
/**
 * Represents an abstract character with common attributes and behavior.
 * Subclasses are expected to implement specific functionality.
 *
 * @param bar The action bar of the character respectively
 */
abstract class AbstractPersonaje(bar: ActionBar) extends Personaje {
  /** A boolean that indicates whether the character's turn in active. */
  var isMyTurn: Boolean
  /** A boolean that returns the current action bar quantity. */
  var status: Int
  /**
   * Returns the character's action bar size.
   *
   * @return The float representing the character's action bar size.
   */
  def barSize(): Float
  /**
   * Returns the character's remaining experience after a turn where
   * their action bar filled up
   *
   * @return The float int the character's remaining action bar size
   *         after removing the full bar's quantity.
   */
  def surplusPoints(): Int
}