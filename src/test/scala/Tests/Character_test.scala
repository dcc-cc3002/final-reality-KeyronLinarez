package Tests

import Armas.Weapon
import Characters.{AbstractPersonaje, Guerrero}
import Party.myParty

class Character_test {
  class TurnSchedulerTest extends munit.FunSuite{
    val character = new Guerrero("Rona", 100, 200, 0)


    test(name = "A character should have a negative value for isMyTurn") {
      assertEquals(character.isMyTurn, false)
    }

  }

}
