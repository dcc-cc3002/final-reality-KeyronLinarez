package Characters

import Armas.{NormalWeapon, Weapon}

class Guerrero(val name: String, var life: Int, var defense: Int, var weapon: Option[NormalWeapon],
               var weight: Int) extends AbstractPersonaje{

}
