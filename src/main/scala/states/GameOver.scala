package states
import gamecontroller.GameController

class GameOver extends AState {
  override def nextState(controller: GameController): Unit = {
    controller.setState(new InitializeBattle)
  }

  override def handle(): Unit = {
    //  initialize new battle
  }


}