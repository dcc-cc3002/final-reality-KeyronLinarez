package Characters

import Armas.MagicWeapon

class MagoBlanco(val name: String, var life: Int, var defense: Int, var weapon: Option[MagicWeapon],
                 var weight: Int,  var mana: Int) extends AbstractMagicPersonaje{

}
