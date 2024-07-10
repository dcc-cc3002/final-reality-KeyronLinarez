package states
import gamecontroller.GameController

class Resetting extends AState {

  def gameOver : Boolean = false
  override def nextState(controller: GameController): Unit = {
    if (gameOver){
      controller.setState(new GameOver)
    } else{
      controller.setState(new Charging)
    }
  }

  override def handle(): Unit = {
    //Go back to charging
    incrementTurnPoints
  }

}