package TurnScheduler

import Armas.Weapon
import Characters.{AbstractPersonaje, Personaje}

class TurnScheduler (party: List[ActionBar]) {

  def addCharacter(character: AbstractPersonaje): Unit = {
    // add character of type personaje to your List[ActionBar]
  }

  def characterDefeated(name: String): Unit = {
    // match name to player defeated, subtract them from the list of actionbar
  }

  def ActionBarSize (index: Int): Int = {
    // returns the total size of an action bar at the given index
    return 0
  }

  def battleStatus (): String = {
    // returns the status of every actionBar in the list
    return ""
  }

  def resetStatus(): Unit = {
    // rests all the actionbar's values to 0
  }

  def checkStatus(index: Int): Boolean = {
    // checks the status of the actionbar at the given index
    return true
  }

  def turnCheckAll(): List[AbstractPersonaje] = {
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
