package Characters

import Armas.Weapon

/**
 * Trait representing a basic character with common attributes.
 */
trait Character {
  /**The name of the character. Default is "DefaultName". */
  private val name: String = "DefaultName"

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
