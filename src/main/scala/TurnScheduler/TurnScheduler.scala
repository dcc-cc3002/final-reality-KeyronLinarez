package TurnScheduler

import Armas.Weapon
import Characters.{AbstractPersonaje, Personaje}
import Party.myParty
import scala.collection.mutable.Queue
import scala.collection.mutable._

class TurnScheduler (current_party: myParty) {
  // queue of actionbars to track turn order
  val turnOrder: Queue[AbstractPersonaje] = Queue()
  def addCharacter(character: AbstractPersonaje): Unit = {
    // add character of type personaje to your List[ActionBar]
    current_party.addCharacter(character)
  }

  def characterDefeated(character: AbstractPersonaje): Unit = {
    // match name to player defeated, subtract them from the list of actionbar
    current_party.dropCharacter(character)
  }

  // this function returns a list with (name, size)
  def ActionBarSizes(current_party: myParty): List[(String, Float)] = {
    var name: String = ""
    var actionbarSize: Int = 0
    var actionList: List[(String, Float)] = List.empty

    // returns the total size of an action bar at the given index
    for (character <- current_party.characters) {
      actionList :+ (character.name, character.barSize())
    }
    return actionList
  }

  // returns the status of every actionBar in the list
  def battleStatus(): List[(String, Boolean)] = {
    var name: String = ""
    var status: Boolean = false
    var actionList: List[(String, Boolean)] = List.empty

    // returns the total size of an action bar at the given index
    for (character <- current_party.characters) {
      actionList :+ (character.name, character.isMyTurn)
    }
    return actionList
  }

  def resetStatus(): Unit = {
    // rests all the actionbar's values to 0
    for (character <- current_party.characters) {
      character.status = 0
    }
  }

  // returns status of
  def checkStatus(character: AbstractPersonaje): Int = {
    // checks the status of the actionbar at the given index
    return character.status
  }

  def incrementTurnPoints(increment: Int) = {
    for (character <- current_party.characters) {
      character.status += increment
    }
  }

  def turnCheckAll() = {
    // queues all the players with full action bars
    // if no characters are finished, do nothing

    // iterate over entire party
    for (character <- current_party.characters) {
      // if the action points of a character exceed the size of the action bar...
      if (character.status >= character.barSize()) {
        // update isMyTurn and queue the character to turnOrder -- not yet sorted
        character.isMyTurn = true
        turnOrder.enqueue(character)
        // if action bar is overflowing, save the surplus
        if (character.status -= character.barSize() > 0) {
          character.surplusPoints() = (character.status -= character.barSize())
        }
        // reset action bar to zero
        character.status = 0
      }
    }
  }

  // check the turn status of a specefic character
  def checkTurnStatus(character: AbstractPersonaje): Boolean = {
    // act based off of the given characters current status
    return character.isMyTurn
  }

  // calcualates turn order for a given turn
  def calculateTurnOrder(): Unit = {
    for (character <- current_party.characters) {
      // Reorder queue based on who has the highest surplus
      val sortedQueue = turnOrder.sortBy(_.surplusPoints())(Ordering[Int].reverse)
      // Clear the original queue
      turnOrder.clear()
      // Enqueue elements from the sorted sequence
      sortedQueue.foreach(turnOrder.enqueue)
    }
  }
}

case class None()
