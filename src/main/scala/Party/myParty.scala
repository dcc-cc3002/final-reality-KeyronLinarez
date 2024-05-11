package Party

import Characters.AbstractCharacter
import TurnScheduler.ActionBar

import scala.::
import scala.collection.mutable.ListBuffer

class myParty() {
  // make tuple containing characters and action bars
  var party_tuple: (ListBuffer[AbstractCharacter], ListBuffer[ActionBar]) = (ListBuffer[AbstractCharacter](), ListBuffer[ActionBar]())
  // edit both lists individually
  var (character_list, actionbar_list) = party_tuple

  def findActionBarForCharacter(character: AbstractCharacter): Option[ActionBar] = {
    actionbar_list.find(_.associatedCharacter == character)
  }
  def addCharacter(character: AbstractCharacter): Unit = {
    character_list = character_list += character

    // Add an associated actionbar for the character
    // For demonstration, let's assume you're creating a new action bar for each character
    actionbar_list += new ActionBar(character)

    // Update party_tuple with the modified lists
    party_tuple = (character_list, actionbar_list)
  }

// Method to remove a character to the party
def dropCharacter(character: AbstractCharacter): Unit = {
  // !! needs an if in case no action bar is passed
  // Find and remove the associated action bar for the character
  //actionbar_list = actionbar_list -= findActionBarForCharacter(character)

  character_list = character_list -= character

  // Update party_tuple with the modified lists
  party_tuple = (character_list, actionbar_list)
}

  def isEmpty(current_party: myParty): Boolean = {
    current_party.character_list.isEmpty
  }

}

