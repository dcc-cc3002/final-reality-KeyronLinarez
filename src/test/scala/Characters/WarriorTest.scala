package Characters

import Armas.Weapon
import Characters.{AbstractCharacter, Warrior}

class WarriorTest extends munit.FunSuite{
  val character = new Warrior("Rona", 100, 200, 0, None)


  test(name = "A character should have a negative value for isMyTurn") {
    assertEquals(character.isMyTurn, false)
  }

}

