package Characters

import Armas.Weapon
import Characters.{AbstractCharacter, Warrior}
import Party.myParty

class NinjaTest extends munit.FunSuite{
  val character = new Ninja("Rona", 100, 200, 0)


  test(name = "A character should have a negative value for isMyTurn") {
    assertEquals(character.isMyTurn, false)
  }

}

