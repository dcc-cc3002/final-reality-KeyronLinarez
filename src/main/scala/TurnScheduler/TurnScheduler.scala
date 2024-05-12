package TurnScheduler

import Armas.Weapon
import Characters.{AbstractCharacter, Character}
import TurnScheduler.aParty

import scala.collection.mutable
import scala.collection.mutable.Queue
import scala.collection.mutable._

// TURN SCHEDULER TAKES IN A PARTY AND ENEMIES
class TurnScheduler (current_party: aParty) {
  // queue of actionbars to track turn order
  val turnOrder: mutable.Queue[AbstractCharacter] = mutable.Queue()

  def addCharacter(character: AbstractCharacter): Unit = {
    // add character(enemies) of type personaje to your List[Characters]
    current_party.addCharacter(character)
  }

  def characterDefeated(character: AbstractCharacter): Unit = {
    // match name to player defeated, subtract them from the list of actionbar
    current_party.dropCharacter(character)
  }

  // this function returns a list with (name, size)
  def ActionBarSizes(current_party: aParty): List[(String, Float)] = {
    var name: String = ""
    var actionbarSize: Int = 0
    var barSizeList: List[(String, Float)] = List.empty

    // returns the total size of an action bar at the given index
    for (character <- current_party.party_list) {
      return barSizeList :+ (character.name, character.action_bar.barSize)
    }
    barSizeList
  }

  // returns the status of every actionBar in the list
  def battleStatus(): List[(String, Boolean)] = {
    var name: String = ""
    var status: Boolean = false
    var actionList: List[(String, Boolean)] = List.empty

    // returns the total size of an action bar at the given index
    for (character <- current_party.party_list) {
      actionList :+ (character.name, character.isMyTurn)
    }
    return actionList
  }

  def resetStatus(): Unit = {
    // rests all the actionbar's values to 0
    for (character <- current_party.party_list) {
      character.action_bar.status = 0
    }
  }

  // returns status of
  def checkStatus(character: AbstractCharacter): Double = {
    // checks the status of the actionbar at the given index
    return character.action_bar.status
  }

  def incrementTurnPoints(increment: Int) = {
    for (character <- current_party.party_list) {
      character.action_bar.status += increment
    }
  }

  def turnCheckAll(): Unit = {
    // queues all the players with full action bars
    // if no characters are finished, do nothing

    // iterate over entire party
    for (character <- current_party.party_list) {
      // if the action points of a character exceed the size of the action bar...
      if (character.action_bar.status >= character.action_bar.barSize) {
        // update isMyTurn and queue the character to turnOrder -- not yet sorted
        character.isMyTurn = true
        turnOrder.enqueue(character)
        // if action bar is overflowing, save the surplus
        if (character.action_bar.status - character.action_bar.barSize > 0) {
          character.action_bar.surplusPoints = (character.action_bar.status - character.action_bar.barSize)
        }
        // reset action bar to zero
        character.action_bar.status = 0
      }
    }
  }

  // check the turn status of a specefic character
  def checkTurnStatus(character: AbstractCharacter): Boolean = character.isMyTurn

  // calculates turn order for a given turn
  def calculateTurnOrder(): Unit = {
    for (character <- current_party.party_list) {
      // Reorder queue based on who has the highest surplus
      //val sortedQueue = turnOrder.sortBy((character.action_bar.surplusPoints)(Ordering[Int].reverse)
      val sortedQueue = turnOrder.sortBy(character => character.action_bar.surplusPoints)(Ordering[Double].reverse)
      // Clear the original queue
      turnOrder.clear()
      // Enqueue elements from the sorted sequence
      sortedQueue.foreach(turnOrder.enqueue)
    }
  }
}