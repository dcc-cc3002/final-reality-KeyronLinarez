package TurnScheduler

import Characters.{AbstractPersonaje, Personaje}
import Party.myParty

class ActionBar (character: AbstractPersonaje) {
  character.isMyTurn = false
  // Extract weapon weight or use default value if None
  val weaponWeight: Int = character.weapon_weight
  // calculate total action bar value
  var barSize: Float = (character.weight + (0.5 * weaponWeight).toFloat)
  // Current value of action bar
  var status: Int = 0
  // left over turn points after a given turn
  var surplusPoints: Int = 0

  //  /** A boolean that returns the current action bar quantity. */
  //  var status: Int
  //  /**
  //   * Returns the character's action bar size.
  //   *
  //   * @return The float representing the character's action bar size.
  //   */
  //  def barSize(): Float
  //  /**
  //   * Returns the character's remaining experience after a turn where
  //   * their action bar filled up
  //   *
  //   * @return The float int the character's remaining action bar size
  //   *         after removing the full bar's quantity.
  //   */
  //  def surplusPoints(): Int

  // current index value corresponding to a character in a party
  val associatedCharacter: AbstractPersonaje = character
}
