package TurnScheduler

import Armas.Weapon
import Characters.{AbstractPersonaje, Personaje}
import Party.myParty

class TurnScheduler (current_party: myParty) {

  def addCharacter(character: AbstractPersonaje): Unit = {
    // add character of type personaje to your List[ActionBar]
    current_party.addCharacter(character)
  }

  def characterDefeated(character: AbstractPersonaje): Unit = {
    // match name to player defeated, subtract them from the list of actionbar
    current_party.dropCharacter(character)
  }

  // this function returns a list with (name, size)
  def ActionBarSizes (current_party: myParty): List[(String, Float)] = {
    var name: String = ""
    var actionbarSize: Int = 0
    var actionList: List[(String, Float)] = List.empty

    // returns the total size of an action bar at the given index
    for (character <- current_party.characters) {
      actionList :+ (character.name, character.barSize())
    }
    return actionList
  }

  def battleStatus (): List[(String, Boolean)] = {
    // returns the status of every actionBar in the list

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

//  def checkStatus(index: Int): Boolean = {
//    // checks the status of the actionbar at the given index
//    return true
//  }

  def turnCheckAll(): myParty = {
    // returns a list of strings containing all the players with full action bars
    // if no characters are finished -- uses isMyTurn!
    return List[None]
    //    - El orden debe ser de mayor a menor, basado
    //    en el excedente que los personajes tuvieron al completar su barra de acción
  }

  def takeAction(character: AbstractPersonaje): String = {
    // act based off of the given characters current status
    // ie. isMyTurn() -> return Fight or doNothing
    return ""
  }

  def calculateTurnOrder(): Unit = {
    // calcualates turn order for a given turn
  }
}


case class None()
