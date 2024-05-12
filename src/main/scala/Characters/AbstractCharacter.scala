package Characters

import Armas.Weapon
import TurnScheduler.ActionBar
import exceptions.Require
/**
 * Represents an abstract character with common attributes and behavior.
 * Subclasses are expected to implement specific functionality.
 *
 * @var action_bar The action bar of the character respectively
 */
abstract class AbstractCharacter(val name: String, var life: Int, var defense: Int, var weight: Double,
                                 var weapon: Option[Weapon]) extends Character {

  // throw exception if not valid state for LIFE, DEF, WGHT
  Require.Stat(life, "life") atLeast 1
  Require.Stat(defense, "defense") atLeast 0
  Require.Stat(weight.toInt, "weight") atLeast 0

//  def getName: String = name

  /** A boolean that indicates whether the character's turn in active. */
  var isMyTurn: Boolean
  // initialize  an action bar when a character is created
  var action_bar: ActionBar = new ActionBar(this)
  // find weapon weight
  def weapon_weight: Double = weapon match {
    case Some(w) => w.weight // If Some(weapon), return the weight of the weapon
    case None => 0.0 // If None, return 0 or any default value you prefer
  }
  // Set weapon weight based on the presence of a weapon

}