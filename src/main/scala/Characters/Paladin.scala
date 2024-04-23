package Characters

import Armas.{NormalWeapon, Weapon}

class Paladin(val name: String, var life: Int, var defense: Int, var weapon: Option[NormalWeapon],
              var weight: Int) extends AbstractNormalPersonaje{

  var isMyTurn: Boolean = false

}
