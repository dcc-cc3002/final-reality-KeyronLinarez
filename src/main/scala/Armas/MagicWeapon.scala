package Armas
//### 2.3. Armamento
//
/**
 * A trait representing a Magic weapon.
 */
trait MagicWeapon extends Weapon{
  /**
   * The magic damage assigned to the current magic weapon
   */
  var magic_attack: Int
//  def attack_=(value: Int): Unit = this.attack
//  def weight_=(value: Double): Unit = this.weight
}

