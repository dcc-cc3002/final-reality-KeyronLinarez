package gamecontroller

import munit.FunSuite
import states.{GameState, InitializeBattle}

class GameControllerTest extends FunSuite {

  class MockController extends GameController {
    var stateChanged = false

    override def setState(state: GameState): Unit = {
      stateChanged = true
      super.setState(state)
    }
  }

  test("InitializeBattle should transition to Attacking state") {
    val controller = new MockController
    val state = new InitializeBattle(controller)

    state.handle()

    assert(controller.stateChanged, "Controller's state should have changed")
  }

  test("InitializeBattle should enter and exit state properly") {
    val controller = new MockController
    val state = new InitializeBattle(controller)

    state.enteringState()
    assert(state.enteringState() == println("Entering InitializeBattle State"), "Entering state should print message")

    state.exitingState()
    assert(state.exitingState() == println("Exiting InitializeBattle State"), "Exiting state should print message")
  }
}
