package Armas
/**
 * Represents a wand
 *
 * @param name The name of the wand.
 * @param attack  The attack life of the wand.
 * @param weight  The weight of the wand.
 * @param weapon  The owner of the wand.
 *
 * @constructor Creates a new wand with the specified attributes.
 *
 */
class Wand (val name: String = "Wand", val attack: Int = 5, val weight: Double = 0.2,
            var owner: String = "",  val magicAttack: Int = 30) extends MagicWeapon {
  // Implementing the setter methods for the abstract vars
  def magicAttack_=(value: Int): Unit = this.magicAttack
  def attack_=(value: Int): Unit = this.attack
  def weight_=(value: Double): Unit = this.weight
}
