package Characters

import Armas.{Axe, Bow, Staff, Sword, Wand, Weapon}
import Characters.{AbstractCharacter, Warrior}

class blackmageTest extends munit.FunSuite{
  val character = new BlackMage("Rona", 100, 200, 0, 100, Some(new Staff))
  val enemy = new Enemy("Mega", 100, 200, 10.0, 0.0)

  val bow = new Bow("testBow")
  val sword = new Sword("testSword")
  val wand = new Wand("testSword")
  val axe = new Axe("testSword")
  val staff = new Staff("testSword")

  test(name = "A character should have a negative value for isMyTurn") {
    assertEquals(character.isMyTurn, false)
  }

  test(name = "A character should attack an enemy") {
    assertEquals(character.attack(enemy), 0)
  }


  test(name = "A character should have a negative value for isMyTurn") {
    assertEquals(character.isMyTurn, false)
  }

  test(name = "A blackmage character should have a negative value for isMyTurn") {
    assertEquals(character.isMyTurn, false)
  }

  test("A blackmage should be able to equip a Sword"){
    character.equip(sword)
    val w = character.getWeapon.get
    assertEquals(w, sword)
  }


  test("blackmage should equip a staff") {
    character.equip(staff)
    val w = character.getWeapon.get
    assertEquals(w, staff)
  }

  test("blackmage should equip a Wand") {
    character.equip(wand)
    val w = character.getWeapon.get
    assertEquals(w, wand)
  }

  test("blackmage should not be able to equip an Axe") {
    val blackmage = new BlackMage("blackmage", 100, 50, 75.0, 100, None)
    blackmage.equip(axe)
    assertEquals(blackmage.weapon, None)
  }

  test("blackmage should not be able to equip a bow") {
    val blackmage = new BlackMage("blackmage", 100, 50, 75.0, 100, None)
    blackmage.equip(bow)
    assertEquals(blackmage.weapon, None)
  }

  test("blackmage should be able to uneqip a wand after equipping it") {
    val blackmage = new BlackMage("blackmage", 100, 50, 75.0, 100, None)
    blackmage.equip(wand)
    assertEquals(blackmage.getWeapon.get, wand)
    blackmage.unEquip()
    assertEquals(blackmage.weapon, None)
  }

}