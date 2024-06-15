package Characters

import Armas.{Bow, MagicWeapon, Staff, Sword, Wand, Weapon}
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
  def canEquip(weapon: Weapon): Boolean = {
    weapon match {
      case _: Sword => true
      case _: Wand => true
      case _: Staff => true
      case _ => false
    }
  }
  //- Un hechizo debe poder lanzarse sobre un objetivo
  //
  //- Al lanzar un hechizo con éxito se debe descontar el maná correspondiente

  def lightning(target: Character): Unit = {
    target match {
      case _: Enemy => hechizo(target)
      case _ => throw new IllegalArgumentException("You cannot damage an ally!")
    }

    useMana(20)
    // 30 % paralize
    target.StatusEffect = "Paralyze"
  }

  def fire(target: Character): Unit = {
    target match {
      case _: Enemy => hechizo(target)
      case _ => throw new IllegalArgumentException("You cannot damage an ally!")
    }
    useMana(15)
    // 20% burn
    target.StatusEffect = "Burn"

  }



  def heal(target: Character): Unit = {
    throw new IllegalArgumentException("Black mage can only use black magic")
  }


  def poison(target: Character): Unit = {
    throw new IllegalArgumentException("Black mage can only use black magic")

  }

  def paralysis(target: Character): Unit = {
    throw new IllegalArgumentException("Black mage can only use black magic")
  }
}
