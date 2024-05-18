package Characters

import Armas.Weapon
import TurnScheduler.ActionBar
import exceptions.Require
import jdk.internal.joptsimple.internal.Messages.message
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
  def canEquip: Boolean

  /** catches exception IF valid weapon is not passed as an object to character */
  try {
    canEquip
    }
  catch {
    case e: IllegalArgumentException => println(s"Caught exception: ${e.getMessage}")
  }
  finally {
    println("Valid weapon")
  }

  override def getName: String = name
  override def getLife: Int = life
  // Setter method for setting life, used by attack
  def setLife(newLife: Int): Unit = {
    // Check if the new life value is valid (greater than or equal to 1)
    Require.Stat(newLife, "life") atLeast 1
    // Update the life attribute with the new value
    life = newLife
  }

  override def getDefense: Int = defense
  override def getWeight: Double = weight


  /** A boolean that indicates whether the character's turn in active. */
  var isMyTurn: Boolean
  /** initialize  an action bar when a character is created */
  var action_bar: ActionBar = new ActionBar(this)
  def statusCurrentBar: Double = action_bar.status
  def ActionBarSize: Double = {
    this.action_bar.barSize
  }
  /** Return weapon weight */
  def weapon_weight: Double = weapon match {
    case Some(w) => w.weight // If Some(weapon), return the weight of the weapon
    case None => 0.0 // If None, return 0 or any default value you prefer
  }
  // Define a method to calculate attack damage
  def attack(target: AbstractCharacter): Int = {
    // if Some(weapon) -> attack damage from weapon, if None -> 0
    val attackDamage = weapon.map(_.attack).getOrElse(0)
    println(attackDamage)

    // Calculate the damage inflicted by subtracting the target's defense points
    val damage = attackDamage - target.getDefense
    // Ensure damage is non-negative
    if (damage > 0){
      target.setLife(life - damage)
      damage
    }
    else 0
  }
}