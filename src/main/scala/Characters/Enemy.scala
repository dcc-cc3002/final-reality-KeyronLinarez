package Characters

import Armas.NormalWeapon
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
class Enemy(val name: String, var life: Int, var defense: Int, var weapon: Option[NormalWeapon],
            var weight: Int) extends AbstractNormalPersonaje {

  /** Indicates whether it's the Guerrero's turn in combat. */
  var isMyTurn: Boolean = false

}
