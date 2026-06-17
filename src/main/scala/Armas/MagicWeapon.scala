package Armas

abstract class MagicWeapon (val name: String,
                            var attack: Int,
                            var weight: Int,
                            val owner: String) extends Weapon {
}
