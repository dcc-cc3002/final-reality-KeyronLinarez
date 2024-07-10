package gamecontroller

import states.GameState

class GameController {
  private var currentState: GameState = _

  // Initialize with the initial state
  def this(initialState: GameState) = {
    this()
    setState(initialState)
  }

  def handle(): Unit = {
    currentState.handle()
  }

  def setState(state: GameState): Unit = {
    if (currentState != null) {
      currentState.exitingState()
    }
    currentState = state
    currentState.enteringState()
  }
}
