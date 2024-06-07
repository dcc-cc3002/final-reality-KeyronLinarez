package Characters

import Armas.{MagicWeapon, Weapon}

abstract class AbstractMagicCharacter(name: String, life: Int, defense: Int, weight: Double, private var mana: Int,
                                      weapon: Option[MagicWeapon] = None) extends AbstractCharacter(name, life, defense, weight, weapon) {
  /**
   * Method to return the mana of a magic character
   */
  def getMana: Int = mana

}
