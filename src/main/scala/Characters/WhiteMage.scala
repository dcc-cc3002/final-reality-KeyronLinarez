package Characters

import Armas.{Axe, Bow, MagicWeapon, Staff, Sword, Wand, Weapon}
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
class WhiteMage(name: String, life: Int, defense: Int, weight: Double, mana: Int, weapon: Option[MagicWeapon])
  extends AbstractMagicCharacter(name, life, defense, weight, mana, weapon){

  /** Indicates whether it's the White Mage's turn in combat. */
//  var isMyTurn: Boolean = false
  /** Check if valid weapon */
  def canEquip(weapon: Weapon): Boolean = {
    weapon match {
      case _: Bow => true
      case _: Wand => true
      case _: Staff => true
      case _ => false
    }
  }

  def heal (target: Character): Unit = {
    // heal 30% of total health
    useMana(15)
  }

  def poison (target: Character): Unit = {
    // 100% poison
    useMana(30)

  }
  def paralysis  (target: Character): Unit = {
    // 100% paralize
    useMana(25)
  }

}
