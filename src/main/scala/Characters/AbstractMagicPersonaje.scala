package Characters

import Armas.MagicWeapon
abstract class AbstractMagicPersonaje (val name: String,
                                       var life: Int,
                                       var defense: Int,
                                       var weight: Int,
                                       var weapon: Option[MagicWeapon],
                                       val mana: Int) extends Personaje{
}