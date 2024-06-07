package Characters

import Armas.{Wand, Weapon}
import Characters.{AbstractCharacter, Warrior}

class WhiteMageTest extends munit.FunSuite{
  val myWand = new Wand()
  val character = new WhiteMage("Rona", 100, 200, 0, 100, Some(myWand))


  test(name = "A character should have a negative value for isMyTurn") {
    assertEquals(character.isMyTurn, false)
  }

}

