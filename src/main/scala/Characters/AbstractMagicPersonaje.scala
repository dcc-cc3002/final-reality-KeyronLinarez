package Characters

import Armas.MagicWeapon
import TurnScheduler.ActionBar
// I wanted every character to have an actionbar, is using this correct?
// ADD MAGIC EXCLUSIVE SHIT
abstract class AbstractMagicPersonaje extends AbstractPersonaje {
  var mana: Int
}