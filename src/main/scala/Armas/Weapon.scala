package Armas

//- Un arma debe tener nombre, puntos de ataque, peso, y un dueño.

trait Weapon {
  val name: String
  var attack: Int
  var weight: Double
  var owner: String
}
