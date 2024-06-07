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
   * A method to set a weapon's owner string after initialization
   */
  def setOwner(character: Character): Unit = {
    owner = character.getName
  }


  def equip(character: Character): Unit = {
    if (this.owner == "") {
      // utilize setOwner AFTER checking if weapon already has an owner
      this.setOwner(character)
    } else {
      throw new IllegalArgumentException("Cannot Equip a weapon that already has an owner")
    }
  }
}

