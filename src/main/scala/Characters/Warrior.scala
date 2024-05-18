package Characters

import Armas.{Axe, Sword, Weapon}
/**
 * Represents a  character
 *
 * @param name The name of the Warrior.
 * @param life  The total life of the Warrior.
 * @param defense  The defense of the Warrior.
 * @param weapon  The weapon of the Warrior.
 * @param weight  The weight of the Warrior.
 *
 * @constructor Creates a new Geurrero with the specified attributes.
 *
 */
class Warrior(name: String, life: Int, defense: Int, weight: Double, weapon: Option[Weapon])
  extends AbstractCharacter(name, life, defense, weight, weapon) {

  /** Indicates whether it's the Warrior's turn in combat. */
  var isMyTurn: Boolean = false
  /** Check if valid weapon */
  def canEquip: Boolean = {
    weapon match {
      case Some(_: Axe) => true
      case Some(_: Sword) => true
      case Some(_) =>  false
      case None => false
    }
  }
}
