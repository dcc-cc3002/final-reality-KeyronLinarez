package Characters

import Armas.{NormalWeapon, Weapon}
/**
 * Represents a Paladin character
 *
 * @param name The name of the Paladin.
 * @param life  The total life of the Paladin.
 * @param defense  The defense of the Paladin.
 * @param weapon  The weapon of the Paladin.
 * @param weight  The weight of the Paladin.
 *
 * @constructor Creates a new Paladin with the specified attributes.
 *
 */
class Paladin(val name: String, var life: Int, var defense: Int, var weapon: Option[NormalWeapon],
              var weight: Int) extends AbstractNormalPersonaje{

  /** Indicates whether it's the paladin's turn in combat. */
  var isMyTurn: Boolean = false

}
