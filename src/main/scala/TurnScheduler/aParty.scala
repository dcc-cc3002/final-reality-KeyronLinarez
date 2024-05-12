package TurnScheduler

import Characters.AbstractCharacter
import TurnScheduler.ActionBar

import scala.::
import scala.collection.mutable.ListBuffer

class aParty() {
  // make tuple containing characters
  //var party_list: (ListBuffer[AbstractCharacter]) = ListBuffer[AbstractCharacter]
  var party_list: ListBuffer[AbstractCharacter] = ListBuffer.empty[AbstractCharacter]

  // edit both lists individually
  //var (character_list, actionbar_list) = party_tuple

  def findActionBarForCharacter(character: AbstractCharacter): ActionBar = {
    character.action_bar
    //actionbar_list.find(_.associatedCharacter == character)
  }
  def addCharacter(character: AbstractCharacter): Unit = {
    party_list = party_list += character

    // Add an associated actionbar for the character
    // For demonstration, let's assume you're creating a new action bar for each character
    //actionbar_list += new ActionBar(character)

    // Update party_tuple with the modified lists
    //party_tuple = (character_list, actionbar_list)
  }

// Method to remove a character to the party
def dropCharacter(character: AbstractCharacter): Unit = {
  // !! needs an if in case no action bar is passed
  // Find and remove the associated action bar for the character
  //actionbar_list = actionbar_list -= findActionBarForCharacter(character)

  party_list = party_list -= character
}

  def isEmpty(current_party: aParty): Boolean = {
    current_party.party_list.isEmpty
  }

}

