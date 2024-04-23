package Tests

import Armas.Weapon
import Characters.{AbstractPersonaje, Personaje}
import Party.myParty
import TurnScheduler.TurnScheduler

class TurnSchedulerTest extends munit.FunSuite{
  val character = new AbstractPersonaje() {
    val name: String = "Rona"
    var life: Int = 100
    var defense: Int = 200
    var weight: Int = 50
    var weapon: Option[Weapon] = None
    var isMyTurn: Boolean = false
    var status: Int = 0
    def barSize(): Float = 100
    def surplusPoints(): Int = 0
  }

  val character2 = new AbstractPersonaje() {
    val name: String = "Xica"
    var life: Int = 50
    var defense: Int = 100
    var weight: Int = 25
    var weapon: Option[Weapon] = None
    var isMyTurn: Boolean = false
    var status: Int = 0
    def barSize(): Float = 50
    def surplusPoints(): Int = 0
  }

  test(name = "A TurnScheduler should add a character to the party") {
    val party = new myParty()
    val scheduler = new TurnScheduler(party)

    scheduler.addCharacter(character)
    assertEquals(party.characters.head, character)
  }

  test(name = "A TurnScheduler should clear all characters from the party") {
    val party = new myParty()
    val scheduler = new TurnScheduler(party)

    scheduler.addCharacter(character)
    assertEquals(party.characters.head, character)
    scheduler.resetStatus()
    assertEquals(true, party.isEmpty(party))
  }


  test(name = "A TurnScheduler should correctly update turn order") {
    val party = new myParty()
    val scheduler = new TurnScheduler(party)

    scheduler.addCharacter(character)
    scheduler.addCharacter(character2)
    scheduler.incrementTurnPoints(100)
    scheduler.turnCheckAll()

    assertEquals(character.isMyTurn, true)
    assertEquals(character2.isMyTurn, true)
    assertEquals(scheduler.turnOrder.dequeue(), character2)
  }
}
