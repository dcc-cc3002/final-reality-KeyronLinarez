package TurnScheduler

import Armas.{Axe, Bow, Staff}
import Characters.{BlackMage, Paladin, Warrior}

class aPartyTest extends munit.FunSuite{
  // make my characters
  val PedroBlackMage = new BlackMage("Pedro", 100, 200, 0, 100, Some(new Staff))
  val JuanWarrior = new Warrior("Juan", 100, 200, 0, Some(new Axe))
  val DiegoPaladin = new Paladin("Diego", 100, 200, 0, Some(new Bow))

  //make my turnsystem
  val myParty = new aParty


  test(name = "test if an emptyList is empty"){
    assertEquals(myParty.isEmpty, true)
  }
  //findActionBarForCharacter
  test(name = "add characters of both types to the party"){
    myParty.addCharacter(PedroBlackMage)
    myParty.addCharacter(JuanWarrior)
    myParty.addCharacter(DiegoPaladin)

    assertEquals(myParty.party_size, 3)
  }

  //addCharacter
  test(name = "drop a character from the party"){
    myParty.dropCharacter(PedroBlackMage)
    myParty.dropCharacter(JuanWarrior)
    myParty.dropCharacter(DiegoPaladin)

    assertEquals(myParty.party_size, 0)
  }


  //dropCharacter

}
