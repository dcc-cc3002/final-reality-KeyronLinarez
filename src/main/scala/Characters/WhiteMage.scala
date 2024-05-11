package Characters

import Armas.{MagicWeapon, Weapon}
/**
 * Represents a  character
 *
 * @param name The name of the White Mage.
 * @param life  The total life of the White Mage.
 * @param defense  The defense of the White Mage.
 * @param weapon  The weapon of the White Mage.
 * @param weight  The weight of the White Mage.
 *
 * @constructor Creates a new White Mage with the specified attributes.
 *
 */
class WhiteMage(name: String, life: Int, defense: Int, weight: Int, mana: Int, weapon: Option[MagicWeapon])
  extends AbstractMagicCharacter(name, life, defense, weight, mana, weapon){

  /** Indicates whether it's the White Mage's turn in combat. */
  var isMyTurn: Boolean = false
//  def weapon_=(x$1: Option[Armas.Weapon]): Unit = {
//    // Implement the logic for setting the weapon
//  }
}
