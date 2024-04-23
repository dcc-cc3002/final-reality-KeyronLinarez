package TurnScheduler

import Characters.{AbstractPersonaje, Personaje}

class ActionBar (character: AbstractPersonaje) {
  // Extract weapon weight or use default value if None
  val weaponWeight: Int = character.weapon.map(_.weight).getOrElse(0)
  // calculate total action bar value
  def barSize(): Double = (character.weight + (0.5 * weaponWeight))
  // Current value of action bar
  def status(): Int = 0
  // left over turn points after a given turn
  def surplusPoints(): Int = 0
}
