package Characters

import Armas.Weapon
import Characters.{AbstractCharacter, Warrior}
import Party.myParty

  class PaladinTest extends munit.FunSuite{
    val character = new Paladin("Rona", 100, 200, 0, None)


    test(name = "A character should have a negative value for isMyTurn") {
      assertEquals(character.isMyTurn, false)
    }

  }

