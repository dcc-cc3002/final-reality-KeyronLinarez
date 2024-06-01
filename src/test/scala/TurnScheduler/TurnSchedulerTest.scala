package TurnScheduler

import Armas.{Axe, Bow, Staff, Sword}
import Characters.{BlackMage, Paladin, Warrior}

import scala.collection.mutable.ListBuffer

class TurnSchedulerTest extends munit.FunSuite{

  // make my characters
  val PedroBlackMage = new BlackMage("Pedro", 100, 200, 0, 100, Some(new Staff))
  val JuanWarrior = new Warrior("Juan", 100, 200, 0, Some(new Axe))
  val DiegoPaladin = new Paladin("Diego", 100, 200, 0, Some(new Bow))

  //make my party
  val myParty = new aParty
  myParty.addCharacter(PedroBlackMage)
  myParty.addCharacter(JuanWarrior)
  myParty.addCharacter(DiegoPaladin)

  // make my turn scheduler
  // should passing myParty mean those characters are added?
  val turnsSystem1 = new TurnScheduler(myParty)
//  println(turnsSystem1.ongoing_party.party_list)
//  println(turnsSystem1.ActionBarSizes())
//  println(turnsSystem1.battleStatus())
  //(s"ListBuffer after initial addCharacters: ${turnsSystem1.ongoing_party.printPartyMembers()}")


  test(name = "addCharacter adds a single character to the queue"){
    turnsSystem1.addCharacter(DiegoPaladin)
    assertEquals(turnsSystem1.getHead, Some(DiegoPaladin))
    turnsSystem1.clearTurnQueue
  }

  test(name = "addCharacter adds a single magic character to the queue"){
    turnsSystem1.addCharacter(PedroBlackMage)
    assertEquals(turnsSystem1.getHead, Some(PedroBlackMage))
    turnsSystem1.clearTurnQueue
    }

  test(name = "if characterDefeated, remove them from the ongoing party"){
    assertEquals(turnsSystem1.ongoing_party.party_size, 3)
    turnsSystem1.retireCharacter(DiegoPaladin)
    turnsSystem1.retireCharacter(JuanWarrior)
    turnsSystem1.retireCharacter(PedroBlackMage)
    assertEquals(turnsSystem1.ongoing_party.party_size, 0)
    assertEquals(turnsSystem1.ongoing_party.isEmpty, true)
  }

  test(name = "a party character's action bar sizes can be received (because weight = 0, )"){
    myParty.addCharacter(PedroBlackMage)
    myParty.addCharacter(JuanWarrior)
    myParty.addCharacter(DiegoPaladin)
    assertEquals(turnsSystem1.ActionBarSizes(),
        ListBuffer(("Pedro", 1.5), (("Juan"), 1.5), ("Diego", 0.25)))
    }

  test(name = "battleStatus of a character whose been added into the turnOrder queue"){
    assertEquals(turnsSystem1.battleStatus(),
      ListBuffer(("Pedro", false), (("Juan"), false), ("Diego", false)))

    turnsSystem1.addCharacter(JuanWarrior)
    assertEquals(turnsSystem1.battleStatus(),
      ListBuffer(("Pedro", false), (("Juan"), true), ("Diego", false)))
    }

  test(name = "incrementTurnPoints to increase action bars by 10"){
    turnsSystem1.incrementTurnPoints(10)
    assertEquals(turnsSystem1.ongoing_party.party_list.head.statusCurrentBar, 10.0)
  }

  test(name = "checkStatus of BlackMage after incremting points (2o in total now)"){
    turnsSystem1.incrementTurnPoints(10)
    assertEquals(turnsSystem1.checkStatus(PedroBlackMage), 20.0)
  }

  test(name = "turnCheckAll when nothing has happened"){
    turnsSystem1.resetStatus()
    turnsSystem1.clearTurnQueue
    turnsSystem1.turnCheckAll()
    assertEquals(turnsSystem1.getNextTurn, None)
  }

  test(name = "resetStatus of the turnScheduler"){
    turnsSystem1.addCharacter(JuanWarrior)
    assertEquals(turnsSystem1.battleStatus(),
      ListBuffer(("Pedro", false), (("Juan"), true), ("Diego", false)))
    turnsSystem1.resetStatus()
    turnsSystem1.clearTurnQueue
    assertEquals(turnsSystem1.battleStatus(),
      ListBuffer(("Pedro", false), (("Juan"), false), ("Diego", false)))
  }
  test(name = "turnCheckAll when action bars are filled"){
    turnsSystem1.incrementTurnPoints(100)
    turnsSystem1.turnCheckAll()
    // DiegoPaladin fills first because he has the lowest weight (0 + (0.5 * bow_weight))
    assertEquals(turnsSystem1.getNextTurn, Some(DiegoPaladin))
    turnsSystem1.resetStatus()
  }

  test(name = "checkTurnStatus"){
      turnsSystem1.addCharacter(PedroBlackMage)
      assertEquals(turnsSystem1.checkTurnStatus(PedroBlackMage), true)
    }

}
