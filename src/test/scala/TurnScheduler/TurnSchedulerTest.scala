package TurnScheduler

import Armas.{Axe, Bow, Staff, Sword}
import Characters.{BlackMage, Paladin, Warrior}

import scala.collection.mutable.ListBuffer

class TurnSchedulerTest {
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

  test(name = "The charging zone can be empty"){
      assertEquals(turnsSystem1.chargingEmpty(), true)
    }

  test(name = "The waiting zone can be empty"){
      assertEquals(turnsSystem1.waitingEmpty(), true)
    }

  test(name = "Your character can be in the charging zone"){
      turnsSystem1.addCharacter(PedroTheMage)
      assertEquals(turnsSystem1.chargingEmpty(), false)
    }

  test(name = "Your character can be waiting for his turn"){
      turnsSystem1.addCharacterWaiting(PedroTheMage)
      assertEquals(turnsSystem1.waitingEmpty(), false)
    }

  test(name = "It's possible delete a character from the charging zone"){
      turnsSystem1.deleteCharacterCharging(PedroTheMage)
      assertEquals(turnsSystem1.chargingEmpty(), true)
    }

  test(name = "It's possible delete a character from the waiting zone"){
      turnsSystem1.deleteCharacterWaiting(PedroTheMage)
      assertEquals(turnsSystem1.waitingEmpty(), true)
    }

  test(name = "The Turn System can calculate the maximum value of the action bar of character"){
      assertEquals(turnsSystem1.maxActionBar(PedroTheMage), 20.0)
    }

  test(name = "The Turn System can increase the value of the action bar of a character"){
      turnsSystem1.chargingActionBar(PedroTheMage)
      assertEquals(PedroTheMage.actionBar(), 5.0)
    }

  test(name = "The Turn System can increase the value of the action bar for all the characters"){
      turnsSystem1.addCharacter(PedroTheMage)
      turnsSystem1.chargingAllActionBar()
      assertEquals(PedroTheMage.actionBar(), 10.0)
    }

  test(name = "The Turn System can reset the action bar of a character"){
      turnsSystem1.resetActionBar(PedroTheMage)
      assertEquals(PedroTheMage.actionBar(), 0.0)
    }

  test(name  = "The Turn System can check when a character complete his action bar"){
      turnsSystem1.addCharacter(JuanTheWarrior)
      turnsSystem1.chargingAllActionBar()
      turnsSystem1.chargingAllActionBar()
      assertEquals(turnsSystem1.waitingEmpty(), false)
      assertEquals(PedroTheMage.actionBar(), 20.0)
    }

  test(name = "The turn System says who has the turn"){
      assertEquals(turnsSystem1.itsYourTurn(), "Its your turn PedroTheMage")
    }


}
