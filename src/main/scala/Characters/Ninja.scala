package Characters

import Armas.{Bow, Staff, Sword, Wand, Weapon}
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
class Ninja(name: String, life: Int, defense: Int, weight: Double, weapon: Option[Weapon])
  extends AbstractCharacter(name, life, defense, weight, weapon) {
  /** Indicates whether it's the ninja's turn in combat. */
  //  var isMyTurn: Boolean = false

  /** Check if valid weapon */
  def canEquip(weapon: Weapon): Boolean = {
    print("hi i am in canEquip, this should break fr fr")
    println(weapon)
    weapon match {
      case _: Bow => true
      case _: Wand => true
      case _: Sword => true
      case _ => false
    }
  }
}