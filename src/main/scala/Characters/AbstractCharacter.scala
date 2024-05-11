package Characters

import Armas.Weapon
import TurnScheduler.ActionBar
/**
 * Represents an abstract character with common attributes and behavior.
 * Subclasses are expected to implement specific functionality.
 *
 * @var action_bar The action bar of the character respectively
 */
abstract class AbstractCharacter(val name: String, var life: Int, var defense: Int, var weight: Int,
                                 var weapon: Option[Weapon]) extends Character {
  /** A boolean that indicates whether the character's turn in active. */
  var isMyTurn: Boolean
  var action_bar: ActionBar = new ActionBar(this)
  var weapon_weight: Int = 0
}