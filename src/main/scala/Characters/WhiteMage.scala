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
  extends AbstractMagicCharacter(name, life, defense, weight, mana, weapon) {

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

  def heal(target: Character): Unit = {
    if (target.isInstanceOf[Enemy]){
      throw new IllegalArgumentException("You cannot heal an enemy!")
    }
    // heal amount = 30% health, convert to integer, add to current target's health
    // *note, health bar is an immutable val representing initial, or maximum, health
    val healing: Int = (target.healthBar * .3.toInt)
    target.setLife(target.getLife + healing)
    useMana(15)
  }

  def poison(target: Character): Unit = {
    target match {
      case _: Enemy => // 100% chance of poisoning
      case _ => throw new IllegalArgumentException("You cannot damage an ally!")
    }
    useMana(30)

  }



  def paralysis(target: Character): Unit = {
    target match {
      case _ => throw new IllegalArgumentException("You cannot damage an ally!")
      case _ => // 100% chance of paralysis
    }
    useMana(25)
  }

  def lightning(target: Character): Unit = {
    throw new IllegalArgumentException("White mage can only use white magic")

  }

  def fire(target: Character): Unit = {
    throw new IllegalArgumentException("White mage can only use white magic")
  }
}
