package Characters

import Armas.Weapon
import Characters.{AbstractPersonaje, Guerrero}
import Party.myParty

  class PaladinTest extends munit.FunSuite{
    val character = new Paladin("Rona", 100, 200, 0)


    test(name = "A character should have a negative value for isMyTurn") {
      assertEquals(character.isMyTurn, false)
    }

  }

