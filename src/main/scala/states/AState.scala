package states
import gamecontroller.GameController
abstract class AState extends GameState{
  protected var controller  = new GameController
  def setState(controller: GameController): Unit = {
    this.controller = controller
  }
}
