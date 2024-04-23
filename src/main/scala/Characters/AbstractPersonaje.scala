package Characters

import Armas.Weapon
// helps grab a type for the party class
abstract class AbstractPersonaje extends Personaje{
  def isMyTurn: Boolean;
}