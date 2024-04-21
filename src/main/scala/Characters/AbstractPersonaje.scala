package Characters

import Armas.NormalWeapon

abstract class AbstractPersonaje (val name: String,
                                   var life: Int,
                                   var defense: Int,
                                   var weapon: Option[NormalWeapon],
                                   var weight: Int) extends Personaje{
}