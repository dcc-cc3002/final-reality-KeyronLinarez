package Party

import Characters.AbstractPersonaje
import TurnScheduler.ActionBar

import scala.::
import scala.collection.mutable.ListBuffer

class myParty() {
  var characters: ListBuffer[AbstractPersonaje] = ListBuffer()

  // Method to add a character to the party
  def addCharacter(character: AbstractPersonaje): Unit = {
    characters = characters += character
  }

// Method to remove a character to the party
def dropCharacter(character: AbstractPersonaje): Unit = {
  characters = characters -= character
}

}

