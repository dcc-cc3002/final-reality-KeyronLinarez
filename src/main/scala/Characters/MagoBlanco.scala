package Characters

import Armas.MagicWeapon
/**
 * Represents a  character
 *
 * @param name The name of the White Mage.
 * @param life  The total life of the White Mage.
 * @param defense  The defense of the White Mage.
 * @param weapon  The weapon of the White Mage.
 * @param weight  The weight of the White Mage.
 *
 * @constructor Creates a new White Mage with the specified attributes.
 *
 */
class MagoBlanco(val name: String, var life: Int, var defense: Int, var weapon: Option[MagicWeapon],
                 var weight: Int,  var mana: Int) extends AbstractMagicPersonaje{

  /** Indicates whether it's the White Mage's turn in combat. */
  var isMyTurn: Boolean = false

}
