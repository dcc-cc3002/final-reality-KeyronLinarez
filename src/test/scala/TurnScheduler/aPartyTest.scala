package TurnScheduler

import Armas.{Axe, Bow, Staff}
import Characters.{BlackMage, Paladin, Warrior}

class aPartyTest {
  // make my characters
  val PedroBlackMage = new BlackMage("Pedro", 100, 200, 0, 100, Some(new Staff))
  val JuanWarrior = new Warrior("Juan", 100, 200, 0, Some(new Axe))
  val DiegoPaladin = new Paladin("Diego", 100, 200, 0, Some(new Bow))

  //make my turnsystem
  val myParty = new aParty
  myParty.addCharacter(PedroBlackMage)
  myParty.addCharacter(JuanWarrior)
  myParty.addCharacter(DiegoPaladin)

  val turnsSystem1 = new TurnScheduler(myParty)

  //isEmpty

  //findActionBarForCharacter

  //addCharacter

  //dropCharacter

}
