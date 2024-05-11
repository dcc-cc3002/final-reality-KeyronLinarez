package Characters

import Armas.{NormalWeapon, Weapon}
/**
 * Represents a  character
 *
 * @param name The name of the Guerrero.
 * @param life  The total life of the Guerrero.
 * @param defense  The defense of the Guerrero.
 * @param weapon  The weapon of the Guerrero.
 * @param weight  The weight of the Guerrero.
 *
 * @constructor Creates a new Geurrero with the specified attributes.
 *
 */
class Guerrero(val name: String, var life: Int, var defense: Int,
               var weight: Int) extends AbstractPersonaje{

  /** Indicates whether it's the Guerrero's turn in combat. */
  var isMyTurn: Boolean = false
//  def weapon_=(x$1: Option[Armas.Weapon]): Unit = {
//    // Implement the logic for setting the weapon
//  }
}
