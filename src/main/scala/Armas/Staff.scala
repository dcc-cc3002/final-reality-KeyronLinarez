package Armas

class Staff (val name: String = "Staff", val attack: Int = 15, val weight: Double = 3.0,
             var owner: String = "",  val magic_attack: Int = 30) extends MagicWeapon {

  // Implementing the setter methods for the abstract vars
  def magic_attack_=(value: Int): Unit = this.magic_attack
//  def attack_=(value: Int): Unit = this.attack
//  def weight_=(value: Double): Unit = this.weight
}
