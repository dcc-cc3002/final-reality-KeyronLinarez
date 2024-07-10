package gamecontroller

import states.GameState

/**
 * The GameController class manages the current state of the game.
 * It can transition between different game states and executes
 * the game logic based off the current state.
 */
class GameController {
  // The current state of the game
  private var currentState: GameState = _

  /**
   * Constructs a GameController with the given initial state.
   *
   * @param initialState The initial state to set for the game controller.
   */
  def this(initialState: GameState) = {
    this()
    setState(initialState)
  }

  /**
   * This method steps into the next phase of battle by performing the actions
   * associated with your current state and the status of your party
   */
  def battleStep(): Unit = {
    currentState.handle()
  }

  /**
   * Sets the current state of the game to the given state.
   * This method calls the exitingState() method of the current state
   * and the enteringState() method of the new state.
   *
   * @param state The new state to transition to.
   */
  def setState(state: GameState): Unit = {
    if (currentState != null) {
      currentState.exitingState()
    }
    currentState = state
    currentState.enteringState()
  }
}
