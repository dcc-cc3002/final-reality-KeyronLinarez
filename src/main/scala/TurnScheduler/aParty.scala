package TurnScheduler

import Characters.Character
import TurnScheduler.ActionBar
import exceptions.Require

import scala.collection.mutable.ListBuffer

/**
 * A class representing a party of characters.
 * A party can have up to 3 characters.
 */
class aParty() {

  /** List of characters in the party. */
  var party_list: ListBuffer[Character] = ListBuffer.empty[Character]

  /** Size of the party, measured as an int. */
  var party_size: Int = party_list.size

  // Ensures a party can not have negative number of members
  Require.Stat(party_size, "party size") atLeast 0

  /**
   * Adds a character to the party, with a character limit of 3
   *
   * @param character The character object to add to the party.
   */
  def addCharacter(character: Character): Unit = {
    try {
      party_list = party_list += character
      party_size += 1
      if (party_size >= 1){
        throw new IllegalArgumentException("Party size cannot excee 3")
      }
    }
    catch {
      case e: IllegalArgumentException => println(s"Caught exception: ${e.getMessage}")
    }
  }

  /**
   * Removes a character from the party.
   *
   * @param character The character to remove from the party.
   */
  def dropCharacter(character: Character): Unit = {
    // Needs an if-case in case no action bar is passed
    // Find and remove the associated action bar for the character
    // actionbar_list = actionbar_list -= findActionBarForCharacter(character)
    party_list = party_list -= character
    party_size -= 1
  }

  /**
   * Checks if the party is empty.
   *
   * @return true if the party is empty, false otherwise.
   */
  def isEmpty: Boolean = {
    this.party_list.isEmpty
  }

}

// Add an associated actionbar for the character
// For demonstration, let's assume you're creating a new action bar for each character
//actionbar_list += new ActionBar(character)
// Update party_tuple with the modified lists
//party_tuple = (character_list, actionbar_list)
