package Characters

import Armas.MagicWeapon
/**
 * Represents a  character
 *
 * @param name The name of the Black Mage.
 * @param life  The total life of the Black Mage.
 * @param defense  The defense of the Black Mage.
 * @param weapon  The weapon of the Black Mage.
 * @param weight  The weight of the Black Mage.
 *
 * @constructor Creates a new Black Mage with the specified attributes.
 *
 */
class BlackMage(name: String, life: Int, defense: Int, weight: Int, weapon: Option[MagicWeapon], mana: Int)
  extends AbstractMagicCharacter(name, life, defense, weight, mana, weapon){
  /** Indicates whether it's the Black Mage's turn in combat. */
  var isMyTurn: Boolean = false
//  def weapon_=(x$1: Option[Armas.Weapon]): Unit = {
//    // Implement the logic for setting the weapon
//  }
}
