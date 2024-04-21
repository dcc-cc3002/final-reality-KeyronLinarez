package Characters

import Armas.Weapon

/** Keyron Linares - Entrega Parcial 1 */
trait Personaje {
  val name: String
  var life: Int
  var defense: Int
  var weight: Int
  var weapon: Option[Weapon]
}

