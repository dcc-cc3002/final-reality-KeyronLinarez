package Characters

import Armas.Weapon
import TurnScheduler.ActionBar

/**
 * Trait representing a basic character with common attributes.
 */
trait Character {
  /**The name of the character. Default is "DefaultName". */
  private val name: String = "DefaultName"
  /**A character's weapon's weight, zero if no weapon equipped. */
  def weaponWeight: Double
  /** A boolean that indicates whether the character's turn in active. */
  var isMyTurn: Boolean
  /** initialize  an action bar when a character is created */
  var action_bar: ActionBar

  def statusCurrentBar: Double

  def actionBarSize: Double

  def getWeapon: Option[Weapon]

  /**
   * The life points of the character. Default is 1.
   */
  private var life: Int = 1

  /**The defense points of the character. Default is 0. */
  private var defense: Int = 0

  /**The weight of the character. Default is 1.0. */
  private var weight: Double = 1.0

  /**
   ** Gets the name of the character.
   * @return the name of the character.
   */
  def getName: String = name

  /**
   * Gets the life points of the character.
   * @return the life points of the character.
   */
  def getLife: Int = life

  /**
   * Gets the defense points of the character.
   * @return the defense points of the character.
   */
  def getDefense: Int = defense

  /**
   * Gets the weight of the character.
   * @return the weight of the character.
   */
  def getWeight: Double = weight
}
