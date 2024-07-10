package states
import gamecontroller.GameController

/**
 * The Resetting state in the game.
 * This state handles resetting the game state after a battle.
 */
class Resetting extends AState {

  /**
   * Indicates if the game is over.
   * This is a placeholder and should be implemented with the actual game over logic.
   */
  def gameOver: Boolean = false

  /**
   * Transitions to the next state.
   * If the game is over, it transitions to the GameOver state.
   * Otherwise, it resets all action bars, clears the turn queue, and transitions to the Charging state.
   *
   * @param controller The game controller managing the state transitions.
   */
  override def nextState(controller: GameController): Unit = {
    if (gameOver) {
      controller.setState(new GameOver)
    } else {
      // Reset all action bars and empty the queue
      scheduler.resetStatus()
      scheduler.clearTurnQueue()
      controller.setState(new Charging)
    }
  }

  /**
   * Handles the logic for the Resetting state.
   * Checks each character in the party and retires those that have died during the battle.
   */
  override def handle(): Unit = {
    for (character <- myParty.party_list) {
      // If character died during battle, retire character
      if (character.healthBar < 0) {
        scheduler.retireCharacter(character)
      }
    }
  }
}
