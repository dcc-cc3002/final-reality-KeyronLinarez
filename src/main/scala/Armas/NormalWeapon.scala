package Armas

abstract class NormalWeapon (val name: String,
                             var attack: Int,
                             var weight: Int,
                             val owner: String) extends Weapon {

}
