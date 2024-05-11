package Characters

import Armas.Weapon
import Characters.{AbstractCharacter, Warrior}
import Party.myParty

class WhiteMageTest extends munit.FunSuite{
  val character = new WhiteMage("Rona", 100, 200, 0, 100, None)


  test(name = "A character should have a negative value for isMyTurn") {
    assertEquals(character.isMyTurn, false)
  }

}

