package states
import gamecontroller.GameController
/**
 * An abstract class that represents a state in the game.
 * This class extends the GameState trait that is used by the game controller
 * to go between different states.
 */
abstract class AState extends GameState {
  /**
   * A protected variable reference for the game controller.
   */
  protected var controller = new GameController

  /**
   * Sets the game controller for this state.
   * This method allows the state to update its reference to the game controller.
   *
   * @param controller The game controller associated with this state.
   */
  def setState(controller: GameController): Unit = {
    this.controller = controller
  }
}