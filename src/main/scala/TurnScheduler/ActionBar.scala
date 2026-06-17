package TurnScheduler

import Characters.{AbstractPersonaje, Personaje}
import Party.myParty

abstract class ActionBar (character: AbstractPersonaje) extends AbstractPersonaje {
  character.isMyTurn = false
  // Extract weapon weight or use default value if None
  val weaponWeight: Int = character.weapon.map(_.weight).getOrElse(0)
  // calculate total action bar value
  def barSize(): Float = (character.weight + (0.5 * weaponWeight).toFloat)
  // Current value of action bar
  def status(): Int = 0
  // left over turn points after a given turn
  def surplusPoints(): Int = 0
}
