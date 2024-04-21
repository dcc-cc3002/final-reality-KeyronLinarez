package Characters

import Armas.MagicWeapon

class MagoBlanco(name: String, life: Int, defense: Int, weapon: Option[MagicWeapon],
                   weight: Int,  mana: Int) extends AbstractMagicPersonaje(name, life, defense, weapon, weight, mana){

}
