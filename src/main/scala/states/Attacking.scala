package states
import gamecontroller.GameController

/**
 * The Attacking state in the game.
 * This state handles the logic for characters attacking their targets.
 */
class Attacking extends AState {

  /**
   * Transitions to the next state.
   * In this case, it transitions to the Resetting state.
   *
   * @param controller The game controller managing the state transitions.
   */
  override def nextState(controller: GameController): Unit = {
    controller.setState(new Resetting)
  }

  /**
   * Handles the logic for the Attacking state.
   * Processes attacks for all characters in the turn order queue until it's empty.
   */
  override def handle(): Unit = {
    scheduler.turnCheckAll()
    while (scheduler.turnOrder.nonEmpty) {
      val character = scheduler.turnOrder.dequeue()
      // code missing to define target :(
      //character.attack(target)
    }
  }
}
