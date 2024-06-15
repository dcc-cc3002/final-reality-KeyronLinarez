package TurnScheduler

import Characters.{AbstractCharacter, Character}

/**
 * Represents the action bar for a character.
 * The action bar keeps track of the character's readiness to take actions based on various attributes.
 *
 * @constructor Creates a new ActionBar for the specified character.
 * @param character The character associated with this action bar.
 */
class ActionBar(character: Character) {

  /** Initially set the character's turn status to false */
  character.isMyTurn = false

  /**
   * The character associated with this action bar.
   * It corresponds to the current index value of a character in a party.
   */
  private val associatedCharacter: Character = character

  /**
   * The weight of the character's weapon.
   * Extracted from the character, or uses a default value if None.
   */
  private val weaponWeight: Double = character.weaponWeight

  /**
   * The total action bar value calculated from the character's weight and weapon weight.
   */
  private var barSize: Double = character.getWeight + (0.5 * weaponWeight)

  /**
   * The current value of the action bar.
   */
  private var status: Double = 0

  /**
   * The leftover turn points after a given turn.
   * This is used to keep track of any remaining action points that can be carried over to the next turn.
   */
  private var leftoverTurnPoints: Double = 0
  /**
   * The leftover turn points after a given turn.
   * This is used to keep track of the current amount of points to add to the subsequent action bar.
   */
  private var surplusPoints: Double = 0

}
