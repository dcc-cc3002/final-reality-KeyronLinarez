package TurnScheduler

import Characters.{AbstractCharacter, Character, Enemy}

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
 * The TurnScheduler class manages the turn order for a party and their enemies.
 *
 * @constructor Creates a new TurnScheduler for the given party.
 * @param current_party The current party of characters.
 */
class TurnScheduler[T <: Character](var current_party: aParty) {

  /**
   * Add chars to TurnSched
   */
  def addToScheduler()

  /** The ongoing party members. */
  var ongoing_party: aParty = current_party

  /** Queue of Characters to track turn order. */
  val turnOrder: mutable.Queue[Character] = mutable.Queue()

  /**
   * Initializes the action bar value for each character in a tuple (Character, ActionBar).
   *
   */
  def initializeBars(): Unit = {
    var charTuples = current_party.party_list.map(character => (character, 0.0))
  }

  /**
   * Calculates the maximum action bar value for each character.
   *
   * @param charTuples The tuple of (characters, action bars) in the party.
   * @return A ListBuffer of tuples containing characters and their maximum action bar values.
   */
  def totalBarSizes(charTuples: ArrayBuffer[(Character, Double)]): ListBuffer[(Character, Double)] = {
    val maxBars = ListBuffer[(Character, Double)]()
    for ((character, value)  <- charTuples) {
      var maxBarValue = 0.0
      character match {
        case _: Enemy =>
          var value = character.getWeight
        case _: AbstractCharacter =>
          if (character.getWeapon.isDefined) {
            var maxBarValue = character.getWeight + 0.5 * character.getWeapon.get.weight
          } else {
            maxBarValue = 0.0
          }
        case _ =>
          maxBarValue = 0.0
      }
      maxBars += ((character, maxBarValue))
    }
    maxBars
  }



  ////////////////

  /**
   * Adds a character to the turn order queue.
   *
   * @param character The character to add to the queue.
   */
  def addCharacter(character: Character): Unit = {
    turnOrder.enqueue(character)
    character.isMyTurn = true
  }

  /**
   * Returns the head of the turn order queue.
   *
   * @return The head of the queue as an Option, or None if the queue is empty.
   */
  def getHead: Option[Character] = turnOrder.headOption

  /**
   * Clears the turn order queue and resets the turn status for all party members.
   */
  def clearTurnQueue(): Unit = {
    turnOrder.clear()
    for (character <- ongoing_party.party_list) {
      character.isMyTurn = false
    }
  }

  /**
   * Retrieves the next character's turn from the queue.
   *
   * @return The next character's turn as an Option, or None if the queue is empty.
   */
  def getNextTurn: Option[Character] = {
    turnOrder.headOption match {
      case Some(character: Character) => Some(character)
      case None => None
    }
  }

  /**
   * Removes defeated party members from the party.
   *
   * @param character The character to retire from the party.
   */
  def retireCharacter(character: Character): Unit = {
    ongoing_party.dropCharacter(character)
    character.isMyTurn = false
  }

  /**
   * Returns a list of tuples containing the name and action bar size for each character in the party.
   *
   * @return A ListBuffer of tuples (character name, action bar size).
   */
  def ActionBarSizes(): ListBuffer[(String, Double)] = {
    var name: String = ""
    var actionbarSize: Int = 0
    var barSizeList: ListBuffer[(String, Double)] = ListBuffer.empty

    for (character <- ongoing_party.party_list) {
      barSizeList.append((character.getName, character.actionBarSize))
    }
    barSizeList
  }




  /**
   * Returns the status of every character in the list.
   *
   * @return A ListBuffer of tuples (character name, turn status).
   */
  def battleStatus(): ListBuffer[(String, Boolean)] = {
    var name: String = ""
    var status: Boolean = false
    var actionList: ListBuffer[(String, Boolean)] = ListBuffer.empty

    for (character <- ongoing_party.party_list) {
      actionList.append((character.getName, character.isMyTurn))
    }
    actionList
  }

  /**
   * Resets the status of all action bars to 0.
   */
  def resetStatus(): Unit = {
    for (character <- ongoing_party.party_list) {
      character.action_bar.status = 0
    }
  }

  /**
   * Returns the status of the specified character's action bar.
   *
   * @param character The character whose action bar status is to be checked.
   * @return The status of the character's action bar.
   */
  def checkStatus(character: Character): Double = {
    character.action_bar.status
  }

  /**
   * Increments the turn points for all characters in the party by the specified amount.
   *
   * @param increment The amount to increment the turn points by.
   */
  def incrementTurnPoints(increment: Int): Unit = {
    for (character <- ongoing_party.party_list) {
      character.action_bar.status += increment
    }
  }
  /**
   * Checks all characters to determine if any have a full action bar and queues them for their turn.
   * Characters with action bars that exceed their size have surplus points calculated and reset.
   * The turn queue is then sorted based on the surplus points.
   */
  def turnCheckAll(): Unit = {
    // Step 1: queue all the players with full action bars
    for (character <- ongoing_party.party_list) {
      if (character.action_bar.status >= character.action_bar.barSize) {
        character.isMyTurn = true
        turnOrder.enqueue(character)
        if (character.action_bar.status - character.action_bar.barSize > 0) {
          character.action_bar.surplusPoints = (character.action_bar.status - character.action_bar.barSize)
          println((character.action_bar.status - character.action_bar.barSize))
        }
        character.action_bar.status = 0
      }
    }
    // Step 2: sort based on who has the biggest surplus points
    val unsortedQueue = scala.collection.mutable.ArrayBuffer[Character]()
    while (turnOrder.nonEmpty) {
      unsortedQueue += turnOrder.dequeue()
    }
    val sortedElements = unsortedQueue.sortBy(_.action_bar.surplusPoints)(Ordering[Double].reverse)
    sortedElements.foreach(turnOrder.enqueue)
  }

  /**
   * Checks the turn status of a specific character.
   *
   * @param character The character whose turn status is to be checked.
   * @return True if it is the character's turn, false otherwise.
   */
  def checkTurnStatus(character: Character): Boolean = character.isMyTurn

}