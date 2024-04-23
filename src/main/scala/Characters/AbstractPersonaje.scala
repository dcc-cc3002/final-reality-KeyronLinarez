package Characters

import Armas.Weapon
// helps grab a type for the party class
abstract class AbstractPersonaje extends Personaje{
  // a boolean that returns whether the characters turn is active
  var isMyTurn: Boolean
  var status: Int
  def barSize(): Float
  def surplusPoints(): Int
}