package gamecontroller

import munit.FunSuite
import states.{Attacking, Charging, GameState, InitializeBattle, Resetting}

class GameControllerTest extends FunSuite {

  test("InitializeBattle should transition to Charging state") {
    val controller = new GameController

    controller.battleStep()

    assertEquals(controller.currentState, new Charging)
  }
  test("Charging State should transition to Attacking state") {
    val controller = new GameController

    // Act Twice
    controller.battleStep()
    controller.battleStep()
    // Assert
    assertEquals(controller.currentState, new Attacking)
  }

  test("Attacking State should transition to Resetting state") {
    val controller = new GameController

    // Act Three times
    controller.battleStep()
    controller.battleStep()
    controller.battleStep()

    // Assert
    assertEquals(controller.currentState, new Resetting)
  }

}
