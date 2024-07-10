package states
import TurnScheduler.{TurnScheduler, aParty}
import gamecontroller.GameController
/**
 * An abstract class that represents a state in the game.
 * This class extends the GameState trait that is used by the game controller
 * to go between different states.
 */
abstract class AState extends GameState {

  // an empty party variable for use in the game controller
  val myParty = new aParty
  // A protected variable reference for the game controller used by the various states
  protected var controller = new GameController
  // A turn scheduler utilized by the game controller
  protected var scheduler = new TurnScheduler(myParty)

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