package Characters

import Armas.{Axe, Sword, Weapon}
import exceptions.Require
/**
 * Represents an abstract character with common attributes and behavior.
 * Subclasses are expected to implement specific functionality.
 *
 * @var action_bar The action bar of the character respectively
 */

abstract class AbstractEnemy(private val name: String, private var life: Int, private var defense: Int, private var weight: Double,
                             weapon: Option[Weapon] = None, var attack: Double) extends AbstractCharacter(name, life, defense, weight, weapon) {
  // throw exception if not valid state for LIFE, DEF, WGHT, ATK
  Require.Stat(life, "life") atLeast 1
  Require.Stat(defense, "defense") atLeast 0
  Require.Stat(weight.toInt, "weight") atLeast 0
  Require.Stat(attack.toInt, "weight") atLeast 0

  /** A boolean that indicates whether the character's turn in active. */
  var isMyTurn: Boolean

  def attackTarget(target: AbstractCharacter): Double = {
    /** if Some(weapon) -> attack damage from weapon, if None -> 0 */
    val attackDamage = attack
    /** Calculate the damage inflicted by subtracting the target's defense points */
    val damage = attackDamage - target.getDefense
    /** Ensure damage is non-negative */
    if (damage > 0) damage else 0
  }

  /** A enemy with a weapon is invalid by default */
  override def canEquip: Boolean = false
}