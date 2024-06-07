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
    println(w)
    println("BRUH")
    assertEquals(w, bow)
  }

  test("Ninja should equip a sword") {
    ninja.equip(sword)
    val w = ninja.getWeapon.get
    print("I AM PRITING OUT W: " + w)
    assertEquals(w, sword)
  }

  test("Ninja should equip a Wand") {
    ninja.equip(wand)
    val w = ninja.getWeapon.get
    assertEquals(w, wand)
  }

  test("Ninja should throw exception for invalid weapons") {
    val ninja = new Ninja("Ninja", 100, 50, 75.0, None)

    println("LAST TEST")
    intercept[IllegalArgumentException] {
      ninja.equip(axe)
    }

    intercept[IllegalArgumentException] {
      ninja.equip(staff)
    }
  }

  test("Ninja should be able to uneqip a Sword after equipping it") {
    val ninja = new Ninja("Ninja", 100, 50, 75.0, Some(new Sword))

//    ninja.equip(None)
//    assertEquals(ninja.weapon, None)
  }

}

