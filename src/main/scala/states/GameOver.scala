package states

import gamecontroller.GameController

/**
 * The GameOver state in the game.
 * This state handles the logic for when the game is over.
 */
class GameOver extends AState {

  /**
   * Transitions to the next state.
   * In this case, it transitions to the InitializeBattle state.
   *
   * @param controller The game controller managing the state transitions.
   */
  override def nextState(controller: GameController): Unit = {
    controller.setState(new InitializeBattle)
  }

  /**
   * Handles the logic for the GameOver state.
   * Removes all characters from the party to prepare for a new battle.
   */
  override def handle(): Unit = {
    // Remove all characters from the party to prepare for a new battle
    for (character <- myParty.party_list) {
      myParty.dropCharacter(character)
    }
  }
}
