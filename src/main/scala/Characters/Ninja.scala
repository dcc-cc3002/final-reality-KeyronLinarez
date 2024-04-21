package Characters

import Armas.{NormalWeapon, Weapon}

class Ninja(name: String, life: Int, defense: Int, weapon: Option[NormalWeapon],
             weight: Int) extends AbstractPersonaje(name, life, defense, weapon, weight){

}
