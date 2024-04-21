package Characters

import Armas.MagicWeapon

class MagoNegro(val name: String, var life: Int, var defense: Int, var weapon: Option[MagicWeapon],
                var weight: Int,var mana: Int) extends AbstractMagicPersonaje{

}
