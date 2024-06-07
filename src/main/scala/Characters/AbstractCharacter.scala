package Characters

import Armas.{Bow, Weapon}
import TurnScheduler.ActionBar
import exceptions.Require
import jdk.internal.joptsimple.internal.Messages.message

import scala.language.postfixOps
/**
 * Represents an abstract character with common attributes and behavior.
 * Subclasses are expected to implement specific functionality.
 *
 * @var action_bar The action bar of the character respectively
 */
abstract class AbstractCharacter(private val name: String, private var life: Int, private var defense: Int, private var weight: Double,
                                 var weapon: Option[Weapon]) extends Character {

  // throw exception if not valid state for LIFE, DEF, WGHT
  Require.Stat(life, "life") atLeast 1
  Require.Stat(defense, "defense") atLeast 0
  Require.Stat(weight.toInt, "weight") atLeast 0

  /** canEquip method performed during new object creation, checks if valid weapon */
  def canEquip(weapon: Weapon): Boolean

  override def getWeapon: Option[Weapon] = weapon

  /** equip allows a weapon equip only if the weapon is valid */
  def equip(weapon: Weapon) : Unit = {
    println("Weapon: " + weapon)
    this.weapon_=(Some(weapon))

    /** catches exception IF valid weapon is not passed as an object to character */
    try {
      println(this.weapon.get)
      println(this)
      println(canEquip(this.weapon.get))
      if (!canEquip(this.weapon.get)){
        throw new IllegalArgumentException("Cannot Equip this weapon")
      }
    }
    catch {
      case e: IllegalArgumentException => println(s"Caught exception: ${e.getMessage}")
    }

    // this if sets the weapon to None if an invalid weapon was detected
    if (this.canEquip(weapon)){
      this.weapon = Some(weapon)
    } else{
      this.weapon = None
    }
  }
  /** unEquip sets character's weapon back to None */
  def unEquip(): Unit = {
    this.weapon = None
  }

  /** getter method for a character's name */
  override def getName: String = name
  /** getter method for a character's life */
  override def getLife: Int = life

  /** Setter method for setting life, used by attack method */
  def setLife(newLife: Int): Unit = {
    // Check if the new life value is valid (greater than or equal to 1)
    Require.Stat(newLife, "life") atLeast 1
    // Update the life attribute with the new value
    life = newLife
  }
  /** Getter method for a character's defense stat */
  override def getDefense: Int = defense
  /** Getter method for a character's weight stat */
  override def getWeight: Double = weight

  /** A boolean that indicates whether the character's turn in active. */
  var isMyTurn: Boolean = false
  /** initialize an action bar when a character is created */
  var action_bar: ActionBar = new ActionBar(this)
  /** A method to checl the current action bar level */
  def statusCurrentBar: Double = action_bar.status
  /** A method to check the total size of a character's action bar */
  def actionBarSize: Double = {
    this.action_bar.barSize
  }

  /** Return weapon weight if weapon is equipped,
   * return nothing if no weapon */
  def weaponWeight: Double = weapon match {
    case Some(w) => w.weight // If Some(weapon), return the weight of the weapon
    case None => 0.0 // If None, return 0 or any default value you prefer
  }
  /** attack calculates attack damage between attacker and attackee
   * This method retrievs a weapon's attack from the attackee's equipped weapon
   * Or returns 0 attack if no weapon is equpped */
  def attack(target: Character): Int = {
    // check if weapon is equipped, DO NOT ATTACK IF NO WEAPON
    if (this.getWeapon.isEmpty){
      0
    }
    if (target.getClass == this.getClass) { // Check if the target is of the same type
      throw new IllegalArgumentException("Cannot attack your ally")
      0 // damage is zero if attacking the same type
    } else {
      // get attack value from weapon, or 0 if None
      val attackDamage = weapon.map(_.attack).getOrElse(0)
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