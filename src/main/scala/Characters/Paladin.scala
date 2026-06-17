package Characters

import Armas.{Axe, Bow, Sword, Wand, Weapon}
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
class Paladin(name: String, life: Int, defense: Int, weight: Double, weapon: Option[Weapon])
  extends AbstractCharacter(name, life, defense, weight, weapon) {
  /** Indicates whether it's the paladin's turn in combat. */
  var isMyTurn: Boolean = false

  /** Check if valid weapon */
  def canEquip: Boolean = {
    weapon match {
      case Some(_: Axe) => true
      case Some(_: Sword) => true
      case Some(_) =>  throw new IllegalArgumentException("Cannot Equip this weapon")
      case None => false
    }
  }
}
