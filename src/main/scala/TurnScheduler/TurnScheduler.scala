package TurnScheduler

import Characters.AbstractCharacter

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
// TURN SCHEDULER TAKES IN A PARTY AND ENEMIES
class TurnScheduler (current_party: aParty) {
  // save starting party members
  var ongoing_party: aParty = current_party
  // queue of actionbars to track turn order
  val turnOrder: mutable.Queue[AbstractCharacter] = mutable.Queue()

  // add character to QUEUE
  def addCharacter(character: AbstractCharacter): Unit = {
    // add character(enemies) of type personaje to your queue
    turnOrder.enqueue(character)
    character.isMyTurn = true
  }

  // returns head of current head of QUEUE, or None if empty
  def getHead: Option[AbstractCharacter] = turnOrder.headOption

  def clearTurnQueue: Unit = {
    turnOrder.clear()
    for (character <- ongoing_party.party_list) {
      character.isMyTurn = false
    }
  }
  // DEFINE THIS AND HAVE IT DEQUEUE
  def getNextTurn: Option[AbstractCharacter] = {
    turnOrder.headOption match {
      case Some(character: AbstractCharacter) => Some(character)
      case None => None
    }
  }

  // removes defeate party members from PARTY
  def retireCharacter(character: AbstractCharacter): Unit = {
    // match name to player defeated, subtract them from the list of actionbar
    ongoing_party.dropCharacter(character)
    character.isMyTurn = false
  }

  // this function returns a list with (name, size)
  def ActionBarSizes(): ListBuffer[(String, Double)] = {
    var name: String = ""
    var actionbarSize: Int = 0
    var barSizeList: ListBuffer[(String, Double)] = ListBuffer.empty

    // returns the total size of an action bar at the given index
    for (character <- ongoing_party.party_list) {
      //println("ACTN BAR  ITERATED")
      //val element: ListBuffer[(String, Double)] = ListBuffer((character.getName,character.ActionBarSize))
      barSizeList.append((character.getName,character.ActionBarSize))
      //print((character.getName, character.ActionBarSize))

    }
    barSizeList
  }

  // returns the status of every character in the list
  def battleStatus(): ListBuffer[(String, Boolean)] = {
    var name: String = ""
    var status: Boolean = false
    var actionList: ListBuffer[(String, Boolean)] = ListBuffer.empty

    // returns the total size of an action bar at the given index
    for (character <- ongoing_party.party_list) {
      actionList.append((character.getName, character.isMyTurn))
      //println("BTL STATUS ITERATED: ")
      //print((character.getName, character.isMyTurn))
    }
    actionList
  }

  def resetStatus(): Unit = {
    // rests all the actionbar's values to 0
    for (character <- ongoing_party.party_list) {
      character.action_bar.status = 0
    }
  }

  // returns status of
  def checkStatus(character: AbstractCharacter): Double = {
    // checks the status of the actionbar at the given index
    return character.action_bar.status
  }

  def incrementTurnPoints(increment: Int): Unit = {
    for (character <- ongoing_party.party_list) {
      character.action_bar.status += increment
    }
  }

  def turnCheckAll(): Unit = {
    // Step 1: queue all the players with full action bars
    // if no characters are finished, do nothing

    // iterate over entire party
    for (character <- ongoing_party.party_list) {
      // if the action points of a character exceed the size of the action bar...
      if (character.action_bar.status >= character.action_bar.barSize) {
        // update isMyTurn and queue the character to turnOrder -- not yet sorted
        character.isMyTurn = true
        turnOrder.enqueue(character)
        // if action bar is overflowing, save the surplus
        if (character.action_bar.status - character.action_bar.barSize > 0) {
          character.action_bar.surplusPoints = (character.action_bar.status - character.action_bar.barSize)
          println((character.action_bar.status - character.action_bar.barSize))
        }
        // reset action bar to zero
        character.action_bar.status = 0
      }
    }
    // Step 2: sort based on who has biggest surplus points
    // dequeue all elements
    val unsortedQueue = scala.collection.mutable.ArrayBuffer[AbstractCharacter]()
    while (turnOrder.nonEmpty) {
      unsortedQueue += turnOrder.dequeue()
    }
    // sort  dequeued elements
    val sortedElements = unsortedQueue.sortBy(_.action_bar.barSize)(Ordering[Double])
    // enqueue  sorted elements back into TurnOrder
    sortedElements.foreach(turnOrder.enqueue)

  }

  // check the turn status of a specific character
  def checkTurnStatus(character: AbstractCharacter): Boolean = character.isMyTurn

}