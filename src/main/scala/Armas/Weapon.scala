package Armas

//- Un arma debe tener nombre, puntos de ataque, peso, y un dueño.

trait Weapon {
  val name: String
  var attack: Int
  var weight: Double
  var owner: String

//  def attack_=(value: Int): Unit = this.attack
//  def weight_=(value: Double): Unit = this.weight
}
