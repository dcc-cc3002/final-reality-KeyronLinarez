package Characters

import Armas.{Axe, Bow, Sword, Wand, Weapon}
import TurnScheduler.ActionBar
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
//  var isMyTurn: Boolean = false

  /** Check if valid weapon */
  def canEquip(Weapon: Weapon): Boolean = {
    weapon match {
      case Some(_: Axe) => true
      case Some(_: Sword) => true
      case Some(_) =>  throw new IllegalArgumentException("Cannot Equip this weapon")
      case None => false
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
