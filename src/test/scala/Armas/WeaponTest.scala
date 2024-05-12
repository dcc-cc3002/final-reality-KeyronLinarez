package Armas

import Characters.{Ninja, Paladin, Warrior}

  class WeaponTest extends munit.FunSuite{
    val my_sword = new Sword()
    val character = new Ninja("Rona", 100, 200, 0, Some(my_sword))

    // Test case for creating a BlackMage character with a Wand
    test(name = "Character with a Wand") {
      val my_sword = new Sword()
      val character = new Ninja("Rona", 100, 200, 0, Some(my_sword))

      character.weapon match {
        case Some(weapon) => println(s"Character has weapon: $weapon")
        case None => println("Character does not have a weapon")
      }

      assert(character.name == "Rona")
      assert(character.life == 100)
      assert(character.defense == 200)
      assert(character.weight == 0)
      assertEquals(character.weapon.isEmpty, false) // Check if the character has a weapon
      assert(character.weapon.get.name == "Sword") // Check if the character's weapon is a Sword
    }

    // Test case for creating a BlackMage character without a weapon
    test("Character without a weapon") {
      val character = new Warrior("Rona", 100, 200, 0, None)

      assert(character.name == "Rona")
      assert(character.life == 100)
      assert(character.defense == 200)
      assert(character.weight == 0)
      assert(character.weapon.isEmpty) // Check if the character does not have a weapon
    }
    // Test case for creating a WhiteMage character with a Staff
    test(name = "Character with a Bow") {
      val my_bow = new Bow()
      val character = new Warrior("Rona", 100, 200, 0, Some(my_bow))

      character.weapon match {
        case Some(weapon) => println(s"Character has weapon: $weapon")
        case None => println("Character does not have a weapon")
      }

      assert(character.name == "Rona")
      assert(character.life == 100)
      assert(character.defense == 200)
      assert(character.weight == 0)
      assertEquals(character.weapon.isEmpty, false) // Check if the character has a weapon
      assert(character.weapon.get.name == "Bow") // Check if the character's weapon is a Wand
    }

    // Test case for creating a BlackMage character without a weapon
    test("Character without a weapon") {
      val character = new Paladin("Rona", 100, 200, 0, None)

      assert(character.name == "Rona")
      assert(character.life == 100)
      assert(character.defense == 200)
      assert(character.weight == 0)
      assert(character.weapon.isEmpty) // Check if the character does not have a weapon

    }
  }
