package states
import gamecontroller.GameController

/**
 * The InitializeBattle state in the game.
 * This state handles the initialization of a battle by adding characters to the turn scheduler.
 */
class InitializeBattle extends AState {

  /**
   * Transitions to the next state.
   * In this case, it transitions to the Charging state.
   *
   * @param controller The game controller managing the state transitions.
   */
  override def nextState(controller: GameController): Unit = {
    controller.setState(new Charging)
  }

  /**
   * Handles the logic for the InitializeBattle state.
   * Adds every character from the party into the turn scheduler.
   */
  override def handle(): Unit = {
    // Add every character from the party into the turn scheduler
    for (character <- myParty.party_list) {
      scheduler.addCharacter(character)
    }
  }
}
