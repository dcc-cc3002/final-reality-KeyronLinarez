package ActionBar

import Armas.Wand
import Characters.BlackMage

class ActionBarTest extends munit.FunSuite{

  // Test case for action bar with a character having a weapon
  test("Action bar with character having a weapon") {
    val my_wand = new Wand()
    val character = new BlackMage("Rona", 100, 200, 10, 100, Some(my_wand))

    character.weapon match {
      case Some(weapon) => println(s"Weapon weight: ${character.weapon_weight}")
      case None => println("Character does not have a weapon")
    }
    println(character.action_bar.barSize)

    assertEquals(character.action_bar.associatedCharacter, character)
    assert(character.action_bar.weaponWeight == 0.2) // Weight of the wand = 0.2
    assert(character.action_bar.barSize == 10.1) // (Character weight + 0.5 * Weapon weight)
    assert(character.action_bar.status == 0.0) // Initial status
    assert(character.action_bar.surplusPoints == 0.0) // Initial surplus points
  }

//  // Test case for action bar with a character without a weapon
//  test("Action bar with character without a weapon") {
//    val character = new BlackMage("Rona", 100, 200, 0, 100, None)
//
//    assert(character.action_bar.associatedCharacter == character)
//    assert(character.action_bar.weaponWeight == 0.0) // No weapon, so weight should be 0
//    assert(character.action_bar.barSize == 50.0) // (Character weight + 0.5 * 0)
//    assert(character.action_bar.status == 0.0) // Initial status
//    assert(character.action_bar.surplusPoints == 0.0) // Initial surplus points
//  }
}
