package Characters

import Armas.{MagicWeapon, Weapon}

abstract class AbstractMagicCharacter(name: String, life: Int, defense: Int, weight: Double, private var mana: Int,
                                      weapon: Option[MagicWeapon] = None) extends AbstractCharacter(name, life, defense, weight, weapon) {
  /**
   * getMans is a getter method that returns the mana of a magic character
   */
  def getMana: Int = mana

  /**
   * useMana calculates the differnce of a magicCharacters mana after using a spell
   *
   * @param manaCost The amount of mana used after a specefic spell
   */
  def useMana(manaCost: Int): Unit = {
    // subtract the cost from current mana
    mana += -(manaCost)
  }

  /** hechizo calculates attack damage between attacker and attackee
   * This method retrieves a weapon's attack from the attackee's equipped MAGIC weapon,
   * as well as considering other magic effects
   * Or returns 0 attack if no weapon is equiped
   *
   * @param target The character to be receiving damage
   */
  def hechizo(target: Character): Int = {
    try {
      // check if weapon is equipped, DO NOT ATTACK IF NO WEAPON
      if (this.getWeapon.isEmpty) {
        throw new IllegalArgumentException("Cannot attack without a weapon equipped!")
      }
      if (target.getClass == this.getClass) { // Check if the target is of the same type
        throw new IllegalArgumentException("Cannot attack your ally")
        0 // damage is zero if attacking the same type
      } else {
        // get MAGIC ATTACK value from weapon, or 0 if None
        val attackDamage = weapon.map(_.magicAttack).getOrElse(0)
        // Calculate the damage inflicted by subtracting the target's defense points
        val damage = attackDamage - target.getDefense
        // Ensure damage is non-negative
        if (damage > 0) {
          target.setLife(target.getLife - damage)
          // if damage is a killing blow, setLife to zero -> NEGATIVE LIFE IS IMPOSSIBLE
          if(target.getLife < 0){
            target.setLife(0)
          }
          // if not a killing blow, return damage value
          damage
        } else 0
      }
    } catch {
      case e: IllegalArgumentException =>
        println(s"Caught IllegalArgumentException: ${e.getMessage}")
        0
      case _: Throwable =>
        println("An unexpected error occurred")
        0
      }
    }
  }

