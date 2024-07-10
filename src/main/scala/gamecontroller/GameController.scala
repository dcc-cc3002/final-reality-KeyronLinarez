package gamecontroller

import states.{GameState, InitializeBattle}

/**
 * The GameController class manages the current state of the game.
 * It can transition between different game states and executes
 * the game logic based off the current state.
 */
class GameController {
  // The current state of the game, always initialized to initialize Batlte
  var currentState: GameState = new InitializeBattle

  /**
   * This method steps into the next phase of battle by performing the actions
   * associated with your current state and the status of your party
   */
  def battleStep(): Unit = {
    currentState.handle()
  }

  /**
   * Sets the current state of the game to the given state.
   *
   * @param state The new state to transition to.
   */
  def setState(state: GameState): Unit = {
    currentState = state
  }
}
