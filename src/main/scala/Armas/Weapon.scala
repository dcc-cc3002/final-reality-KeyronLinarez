package Armas

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
}
