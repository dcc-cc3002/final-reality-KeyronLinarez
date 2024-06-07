package Armas

import Characters.Character

/**
 * A trait representing a weapon.
 */
trait Weapon {
  /**
   * The name of the weapon.
   */
  val name: String

  /**
   * The attack power of the weapon.
   */
  var attack: Int

  /**
   * The weight of the weapon in kilograms.
   */
  var weight: Double

  /**
   * The name of the owner of the weapon.
   */
  var owner: String

  /**
   * Equips the weapon to the specified character.
   *
   * @param character The character that the weapon is being equipped by
   */
  def setOwner(character: Character): Unit = {
    owner = character.getName
  }

  /**
   * Equips the weapon to the specified character.
   *
   * @param character The character to whom the weapon should be equipped.
   * @throws IllegalArgumentException if the weapon already has an owner.
   */

  def equip(character: Character): Unit = {
    if (this.owner == "") {
      // utilize setOwner AFTER checking if weapon already has an owner
      this.setOwner(character)
    } else {
      throw new IllegalArgumentException("Cannot Equip a weapon that already has an owner")
    }
  }
}

