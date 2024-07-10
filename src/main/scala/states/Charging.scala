package states

import gamecontroller.GameController

/**
 * The Charging state in the game.
 * This state handles the logic for when a character is charging.
 */
class Charging extends AState {

  /**
   * Transitions to the next state.
   * In this case, it transitions to the Attacking state.
   *
   * @param controller The game controller managing the state transitions.
   */
  override def nextState(controller: GameController): Unit = {
    controller.setState(new Attacking)
  }

  /**
   * Handles the logic for the Charging state.
   * Increments every action bar by 10 and then checks the turn status for all characters.
   */
  override def handle(): Unit = {
    // Increment every action bar by 10
    scheduler.incrementTurnPoints(10)

    // Check the turn status for all characters
    scheduler.turnCheckAll()
  }
}
