package Characters

import Armas.Weapon
import Characters.{AbstractPersonaje, Guerrero}
import Party.myParty

class EnemyTest extends munit.FunSuite{
  val character = new Enemy("Rona", 100, 200, 0)


  test(name = "A character should have a negative value for isMyTurn") {
    assertEquals(character.isMyTurn, false)
  }

}

