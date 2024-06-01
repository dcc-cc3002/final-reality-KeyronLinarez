package TurnScheduler

import Characters.AbstractCharacter
import TurnScheduler.ActionBar
import exceptions.Require

import scala.::
import scala.collection.mutable.ListBuffer

class aParty() {
  // make tuple containing characters
  //var party_list: (ListBuffer[AbstractCharacter]) = ListBuffer[AbstractCharacter]
  var party_list: ListBuffer[Character] = ListBuffer.empty[Character]
  var party_size: Int = party_list.size
  // ensures a party can only have 3 members
  Require.Stat(party_size, "party size") atLeast 3
  // edit both lists individually
  //var (character_list, actionbar_list) = party_tuple

  def addCharacter(character: Character): Unit = {
    party_list = party_list += character
    party_size += 1

  }

  // Add an associated actionbar for the character
  // For demonstration, let's assume you're creating a new action bar for each character
  //actionbar_list += new ActionBar(character)
  // Update party_tuple with the modified lists
  //party_tuple = (character_list, actionbar_list)
// Method to remove a character to the party
def dropCharacter(character: Character): Unit = {
  // !! needs an if in case no action bar is passed
  // Find and remove the associated action bar for the character
  //actionbar_list = actionbar_list -= findActionBarForCharacter(character)

  party_list = party_list -= character
  party_size -= 1
}

  def isEmpty: Boolean = {
    this.party_list.isEmpty
  }

}

