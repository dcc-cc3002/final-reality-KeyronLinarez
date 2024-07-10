package Characters

import Armas.{Axe, Sword, Weapon}
import TurnScheduler.ActionBar
import exceptions.Require
/**
 * Represents an abstract character with common attributes and behavior.
 * Subclasses are expected to implement specific functionality.
 *
 */

abstract class AbstractEnemy(private val name: String, private var life: Int, private var defense: Int, private var weight: Double,
                             weapon: Option[Weapon] = None, var attack: Double) extends AbstractCharacter(name, life, defense, weight, weapon) {
  // throw exception if not valid state for LIFE, DEF, WGHT, ATK
  Require.Stat(life, "life") atLeast 1
  Require.Stat(defense, "defense") atLeast 0
  Require.Stat(weight.toInt, "weight") atLeast 0
  Require.Stat(attack.toInt, "weight") atLeast 0

  /**
   * The method that controls an enemies attacking behavior
   *
   * @param target The target of an attacker, a player character who will be damaged
   */
  def attackTarget(target: AbstractCharacter): Double = {
    /** if Some(weapon) -> attack damage from weapon, if None -> 0 */
    val attackDamage = attack
    /** Calculate the damage inflicted by subtracting the target's defense points */
    val damage = attackDamage - target.getDefense
    /** Ensure damage is non-negative */
    if (damage > 0) damage else 0
  }

  /** A enemy with a weapon is invalid by default */
  /** An initial status effect of normal */
  var StatusEffect: (String, Int) = ("Normal", 0)
  /** A boolean that indicates whether the character's turn in active. */
  override var isMyTurn: Boolean = false
  /** initialize  an action bar when a character is created */
  override var action_bar: ActionBar = new ActionBar(this)
  /** initialize  an action bars points */
  override def statusCurrentBar: Double = 0
  /** Calculate a bars current weight */
  override def actionBarSize: Double = weight
}