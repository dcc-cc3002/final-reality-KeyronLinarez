package Characters

import Armas.{MagicWeapon, Weapon}
import TurnScheduler.ActionBar
// I wanted every character to have an actionbar, is using this correct?
// ADD MAGIC EXCLUSIVE SHIT

abstract class AbstractMagicCharacter(name: String, life: Int, defense: Int, weight: Int, mana: Int,
                             weapon: Option[MagicWeapon] = None) extends AbstractCharacter(name, life, defense, weight, None) {

}

//abstract class AbstractMagicCharacter(var weapon: Option[MagicWeapon]) extends AbstractCharacter {
//  var mana: Int
//  var weapon: Option[MagicWeapon]
//
//}