package Characters

import Armas.Weapon
/**
 * Represents a Paladin character
 *
 * @param name The name of the Paladin.
 * @param life  The total life of the Paladin.
 * @param defense  The defense of the Paladin.
 * @param weapon  The weapon of the Paladin.
 * @param weight  The weight of the Paladin.
 *
 * @constructor Creates a new Paladin with the specified attributes.
 *
 */
class Paladin(name: String, life: Int, defense: Int, weight: Int, weapon: Option[Weapon])
  extends AbstractCharacter(name, life, defense, weight, weapon) {
  /** Indicates whether it's the paladin's turn in combat. */
  var isMyTurn: Boolean = false

}
