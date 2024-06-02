package Characters

import Armas.{Bow, Sword, Wand}
//class Ninja(name: String, life: Int, defense: Int, weight: Double, weapon: Option[Weapon])
//  extends AbstractCharacter(name, life, defense, weight, weapon)
class NinjaTest extends munit.FunSuite{
  println("ninjatest")
  val ninja = new Ninja("testNinja", 100, 200, 10, None)
  val bow = new Bow("testBow")
  val sword = new Sword("testSword")
  val wand = new Wand("testSword")

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

}

