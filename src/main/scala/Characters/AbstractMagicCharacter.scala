package Characters

import Armas.{MagicWeapon, Weapon}

abstract class AbstractMagicCharacter(name: String, life: Int, defense: Int, weight: Double, private var mana: Int,
                                      weapon: Option[MagicWeapon] = None) extends AbstractCharacter(name, life, defense, weight, weapon) {
  /**
   * Method to return the mana of a magic character
   */
  def getMana: Int = mana

  /** hechizo calculates attack damage between attacker and attackee
   * This method retrieves a weapon's attack from the attackee's equipped MAGIC weapon,
   * as well as considering other magic effects
   * Or returns 0 attack if no weapon is equiped
   *
   * @param target The character to be receiving damage */
  def hechizo(target: Character): Int = {
    // check if weapon is equipped, DO NOT ATTACK IF NO WEAPON
    if (this.getWeapon.isEmpty){
      0
    }
    if (target.getClass == this.getClass) { // Check if the target is of the same type
      throw new IllegalArgumentException("Cannot attack your allyQ")
      0 // damage is zero if attacking the same type
    } else {
      // get MAGIC ATTACK value from weapon, or 0 if None
      val attackDamage = weapon.map(_.magicAttack).getOrElse(0)
      // Calculate the damage inflicted by subtracting the target's defense points
      val damage = attackDamage - target.getDefense
      // Ensure damage is non-negative
      if (damage > 0) {
        target.setLife(target.getLife - damage)
        damage
      } else 0
    }
  }
}
