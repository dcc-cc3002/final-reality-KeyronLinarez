package states

import gamecontroller.GameController
/**
 * The GameState trait represents a state in the game.
 * It defines the methods that all concrete game states must implement.
 */
trait GameState {

  /**
   * Transitions to the next state.
   *
   * @param controller The game controller managing the state transitions.
   */
  def nextState(controller: GameController): Unit

  /**
   * Handles the logic for the current state.
   */
  def handle(): Unit
}
