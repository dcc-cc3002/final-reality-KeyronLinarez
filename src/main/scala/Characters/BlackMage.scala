package Characters

import Armas.{MagicWeapon, Staff, Sword, Wand, Weapon}
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
class BlackMage(name: String, life: Int, defense: Int, weight: Double, mana: Int, weapon: Option[MagicWeapon])
  extends AbstractMagicCharacter(name, life, defense, weight, mana, weapon) {
  /** Check if valid weapon */
  def canEquip: Boolean = {
    weapon match {
      case Some(_: Staff) => true
      case Some(_: Wand) => true
      case Some(_: Sword) => true
      case Some(_) =>  false
      case None => true
    }
  }
}
