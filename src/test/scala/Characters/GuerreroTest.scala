package Characters

import Armas.Weapon
import Characters.{AbstractCharacter, Warrior}
import Party.myParty

class GuerreroTest extends munit.FunSuite{
  val character = new Warrior("Rona", 100, 200, 0)


  test(name = "A character should have a negative value for isMyTurn") {
    assertEquals(character.isMyTurn, false)
  }

}

