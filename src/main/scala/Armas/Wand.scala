package Armas
/**
 * Represents a wand weapon
 *
 * @param name The name of the wand.
 * @param attack  The attack life of the wand.
 * @param weight  The weight of the wand.
 * @param owner  The owner of the wand.
 *
 * @constructor Creates a new wand with the specified attributes.
 *
 */
class Wand (val name: String = "Wand", val attack: Int = 5, val weight: Double = 0.2,
            var owner: String = "",  val magicAttack: Int = 30) extends MagicWeapon {
  /** Getter for the magic attack value of a magic weapon */
  def magic_attack_=(value: Int): Unit = this.magicAttack

  /** Getter for the (non-magic) attack value of a magic weapon */
  def attack_=(value: Int): Unit = this.attack

  /** Getter for the weight value of a magic weapon */
  def weight_=(value: Double): Unit = this.weight
}
