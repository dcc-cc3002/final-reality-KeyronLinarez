package Characters

import Armas.{NormalWeapon, Weapon}
/**
 * Represents a  character
 *
 * @param name The name of the Ninja.
 * @param life  The total life of the Ninja.
 * @param defense  The defense of the Ninja.
 * @param weapon  The weapon of the Ninja.
 * @param weight  The weight of the Ninja.
 *
 * @constructor Creates a new Ninja with the specified attributes.
 *
 */
class Ninja(val name: String, var life: Int, var defense: Int, var weapon: Option[NormalWeapon],
            var weight: Int) extends AbstractNormalPersonaje{
  /** Indicates whether it's the ninja's turn in combat. */
  var isMyTurn: Boolean = false

}
