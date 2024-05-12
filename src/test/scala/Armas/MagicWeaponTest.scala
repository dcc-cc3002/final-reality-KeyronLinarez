package Armas

import Characters.{BlackMage, WhiteMage}

class MagicWeaponTest extends munit.FunSuite{
  val my_wand = new Wand()
  val character = new BlackMage("Rona", 100, 200, 0, 100, Some(my_wand))

  // Test case for creating a BlackMage character with a Wand
  test(name = "Character with a Wand") {
    val myWand = new Wand()
    val character = new BlackMage("Rona", 100, 200, 0, 100, Some(myWand))

    character.weapon match {
      case Some(weapon) => println(s"Character has weapon: $weapon")
      case None => println("Character does not have a weapon")
    }

    assert(character.name == "Rona")
    assert(character.life == 100)
    assert(character.defense == 200)
    assert(character.weight == 0)
    assert(character.mana == 100)
    assertEquals(character.weapon.isEmpty, false) // Check if the character has a weapon
    assert(character.weapon.get.name == "Wand") // Check if the character's weapon is a Wand
  }

  // Test case for creating a BlackMage character without a weapon
  test("Character without a weapon") {
    val character = new BlackMage("Rona", 100, 200, 0, 100, None)

    assert(character.name == "Rona")
    assert(character.life == 100)
    assert(character.defense == 200)
    assert(character.weight == 0)
    assert(character.mana == 100)
    assert(character.weapon.isEmpty) // Check if the character does not have a weapon
  }
  // Test case for creating a WhiteMage character with a Staff
  test(name = "Character with a Staff") {
    val my_staff = new Staff()
    val character = new WhiteMage("Rona", 100, 200, 0, 100, Some(my_staff))

    character.weapon match {
      case Some(weapon) => println(s"Character has weapon: $weapon")
      case None => println("Character does not have a weapon")
    }

    assert(character.name == "Rona")
    assert(character.life == 100)
    assert(character.defense == 200)
    assert(character.weight == 0)
    assert(character.mana == 100)
    assertEquals(character.weapon.isEmpty, false) // Check if the character has a weapon
    assert(character.weapon.get.name == "Staff") // Check if the character's weapon is a Wand
  }

  // Test case for creating a BlackMage character without a weapon
  test("Character without a weapon") {
    val character = new BlackMage("Rona", 100, 200, 0, 100, None)

    assert(character.name == "Rona")
    assert(character.life == 100)
    assert(character.defense == 200)
    assert(character.weight == 0)
    assert(character.mana == 100)
    assert(character.weapon.isEmpty) // Check if the character does not have a weapon

  }
}



