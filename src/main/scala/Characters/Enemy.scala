package Characters

import Armas.Weapon
/**
 * Represents an enemy character
 *
 * @param name The name of the Enemy.
 * @param life  The total life of the Enemy.
 * @param defense  The defense of the Enemy.
 * @param weapon  The weapon of the Enemy.
 * @param weight  The weight of the Enemy.
 *
 * @constructor Creates a new Enemy with the specified attributes.
 *
 */
class Enemy(name: String, life: Int, defense: Int, weight: Double, weapon: Option[Weapon])
  extends AbstractCharacter(name, life, defense, weight, weapon) {

  /** Indicates whether it's the Guerrero's turn in combat. */
  var isMyTurn: Boolean = false
}
