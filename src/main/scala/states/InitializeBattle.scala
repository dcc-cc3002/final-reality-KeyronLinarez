package states
import gamecontroller.GameController

class InitializeBattle extends AState {
  override def nextState(controller: GameController): Unit = {
    controller.setState(new Charging)
  }

  override def handle(): Unit = ???


//  + Inicializar una partida.

}
