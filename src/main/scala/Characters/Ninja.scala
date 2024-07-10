package Characters

import Armas.{Bow, Staff, Sword, Wand, Weapon}
import TurnScheduler.ActionBar
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
    weapon match {
      case _: Bow => true
      case _: Wand => true
      case _: Sword => true
      case _ => false
    }
  }

  /** An initial status effect of normal */
  var StatusEffect: (String, Int) = ("Normal", 0)
  /** A boolean that indicates whether the character's turn in active. */
  override var isMyTurn: Boolean = false
  /** initialize  an action bar when a character is created */
  override var action_bar: ActionBar = new ActionBar(this)
  /** initialize  an action bars points */
  override def statusCurrentBar: Double = 0
  /** Calculate a bars current weight */
  override def actionBarSize: Double = weight + 0.5*weaponWeight
}