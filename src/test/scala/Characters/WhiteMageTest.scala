package Characters

import Armas.{Axe, Bow, Staff, Sword, Wand, Weapon}
import Characters.{AbstractCharacter, Warrior}

class WhiteMageTest extends munit.FunSuite{
  val myWand = new Wand()
  val character = new WhiteMage("Rona", 100, 200, 0, 100, Some(myWand))

  val bow = new Bow("testBow")
  val sword = new Sword("testSword")
  val wand = new Wand("testSword")
  val axe = new Axe("testSword")
  val staff = new Staff("testSword")


  test(name = "A character should have a negative value for isMyTurn") {
    assertEquals(character.isMyTurn, false)
  }

  test(name = "A whitemage character should have a negative value for isMyTurn") {
    assertEquals(character.isMyTurn, false)
  }

  test("A whitemage should be able to equip a Bow"){
    character.equip(bow)
    val w = character.getWeapon.get
    assertEquals(w, bow)
  }


  test("whitemage should equip a sword") {
    character.equip(staff)
    val w = character.getWeapon.get
    assertEquals(w, staff)
  }

  test("whitemage should equip a Wand") {
    character.equip(wand)
    val w = character.getWeapon.get
    assertEquals(w, wand)
  }

  test("whitemage should not be able to equip an Axe") {
    val whitemage = new WhiteMage("whitemage", 100, 50, 75.0, None)
    whitemage.equip(axe)
    assertEquals(whitemage.weapon, None)

  }

  test("whitemage should not be able to equip a Sword") {
    val whitemage = new WhiteMage("whitemage", 100, 50, 75.0, None)
    whitemage.equip(sword)
    assertEquals(whitemage.weapon, None)
  }

  test("whitemage should be able to uneqip a wand after equipping it") {
    val whitemage = new WhiteMage("whitemage", 100, 50, 75.0, None)
    whitemage.equip(wand)
    assertEquals(whitemage.getWeapon.get, wand)
    whitemage.unEquip()
    assertEquals(whitemage.weapon, None)
  }

}

