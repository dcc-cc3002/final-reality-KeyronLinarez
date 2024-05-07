package Characters

import Armas.MagicWeapon
/**
 * Represents a  character
 *
 * @param name The name of the Black Mage.
 * @param life  The total life of the Black Mage.
 * @param defense  The defense of the Black Mage.
 * @param weapon  The weapon of the Black Mage.
 * @param weight  The weight of the Black Mage.
 *
 * @constructor Creates a new Black Mage with the specified attributes.
 *
 */
class MagoNegro(val name: String, var life: Int, var defense: Int, var weapon: Option[MagicWeapon],
                var weight: Int,var mana: Int) extends AbstractMagicPersonaje{

  /** Indicates whether it's the Black Mage's turn in combat. */
  var isMyTurn: Boolean = false

}
