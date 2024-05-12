package Characters

import Armas.{MagicWeapon, Weapon}
import Characters.{AbstractCharacter, Warrior}

class BlackMageTest extends munit.FunSuite{
  val character = new BlackMage("Rona", 100, 200, 0, 100, None)


  test(name = "A character should have a negative value for isMyTurn") {
    assertEquals(character.isMyTurn, false)
  }

}

