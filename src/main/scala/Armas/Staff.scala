package Armas
/**
 * Represents a staff weapon
 *
 * @param name The name of the staff.
 * @param attack  The attack life of the staff.
 * @param weight  The weight of the staff.
 * @param owner  The owner of the staff.
 *
 * @constructor Creates a new staff with the specified attributes.
 *
 */
class Staff (val name: String = "Staff", val attack: Int = 15, val weight: Double = 3.0,
             var owner: String = "",  val magicAttack: Int = 30) extends MagicWeapon {

  /** Getter for the magic attack value of a magic weapon */
  def magic_attack_=(value: Int): Unit = this.magicAttack
  /** Getter for the (non-magic) attack value of a magic weapon */
  def attack_=(value: Int): Unit = this.attack
  /** Getter for the weight value of a magic weapon */
  def weight_=(value: Double): Unit = this.weight
}
