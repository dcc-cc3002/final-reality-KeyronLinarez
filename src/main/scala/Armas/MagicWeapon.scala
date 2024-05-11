package Armas
//### 2.3. Armamento
//
//- Un arma debe tener nombre, puntos de ataque, peso, y un dueño.
//
//  - Un arma mágica debe tener además puntos de ataque mágico.
trait MagicWeapon {
  val name: String
  var attack: Int
  var weight: Int
  val owner: String
  var magic_attack: Int
}

