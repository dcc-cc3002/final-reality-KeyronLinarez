package states
import gamecontroller.GameController

class Charging extends AState {
  override def nextState(controller: GameController): Unit = {
    controller.setState(new Attacking)
  }
  override def handle(): Unit = {
    //  + Hacer que un personaje equipe un arma.
  }




}