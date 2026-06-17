package Characters

import Armas.{MagicWeapon, Staff, Weapon}
import Characters.{AbstractCharacter, Warrior}

class BlackMageTest extends munit.FunSuite{
  val character = new BlackMage("Rona", 100, 200, 0, 100, Some(new Staff))
  val enemy = new Enemy("Mega", 100, 200, 10.0, 0.0)

  test(name = "A character should have a negative value for isMyTurn") {
    assertEquals(character.isMyTurn, false)
  }

  test(name = "A character should attack an enemy") {
    assertEquals(character.attack(enemy), 0)
  }

}

