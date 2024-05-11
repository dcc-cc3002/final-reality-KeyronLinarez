package Characters

import Armas.Weapon
import Characters.{AbstractCharacter, Warrior}
import Party.myParty

class BlackMageTest extends munit.FunSuite{
  val character = new BlackMage("Rona", 100, 200, 0, 100)


  test(name = "A character should have a negative value for isMyTurn") {
    assertEquals(character.isMyTurn, false)
  }

}

