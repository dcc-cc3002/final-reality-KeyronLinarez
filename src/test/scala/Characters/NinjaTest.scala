package Characters

import Armas.{Axe, Bow, Staff, Sword, Wand}
//class Ninja(name: String, life: Int, defense: Int, weight: Double, weapon: Option[Weapon])
//  extends AbstractCharacter(name, life, defense, weight, weapon)
class NinjaTest extends munit.FunSuite{
  println("ninjatest")
  val ninja = new Ninja("testNinja", 100, 200, 10, None)
  val bow = new Bow("testBow")
  val sword = new Sword("testSword")
  val wand = new Wand("testSword")
  val axe = new Axe("testSword")
  val staff = new Staff("testSword")

  test(name = "A ninja character should have a negative value for isMyTurn") {
    assertEquals(ninja.isMyTurn, false)
  }

  test("A ninja should be able to equip a Bow"){
    ninja.equip(bow)
    val w = ninja.getWeapon.get
    assertEquals(w, bow)
  }


  test("Ninja should equip a sword") {
    ninja.equip(sword)
    val w = ninja.getWeapon.get
    assertEquals(w, sword)
  }

  test("Ninja should equip a Wand") {
    ninja.equip(wand)
    val w = ninja.getWeapon.get
    assertEquals(w, wand)
  }

  test("Ninja should not be able to equip an Axe") {
    val ninja = new Ninja("Ninja", 100, 50, 75.0, None)
    ninja.equip(axe)
    assertEquals(ninja.weapon, None)

  }

  test("Ninja should not be able to equip a Staff") {
    val ninja = new Ninja("Ninja", 100, 50, 75.0, None)
    ninja.equip(staff)
    assertEquals(ninja.weapon, None)
  }

  test("Ninja should be able to uneqip a Sword after equipping it") {
    val ninja = new Ninja("Ninja", 100, 50, 75.0, None)
    ninja.equip(sword)
    assertEquals(ninja.getWeapon.get, sword)
    ninja.unEquip()
    assertEquals(ninja.weapon, None)
  }

  // Test case for getDefense method
  test("getDefense method should return the defense of the character") {
    assertEquals(ninja.getDefense, 200)
  }

  // Test case for getWeight method
  test("getWeight method should return the weight of the character") {
    assertEquals(ninja.getWeight, 10.0)
  }

  // Test case for getDefense method
  test("getName method should return the name of the character") {
    assertEquals(ninja.getName, "testNinja")
  }

  // Test case for getWeight method
  test("getLife method should return the life of the character") {
    assertEquals(ninja.getLife, 100)
  }
}

