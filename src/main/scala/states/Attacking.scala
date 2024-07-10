package states
import gamecontroller.GameController

class Attacking extends AState {
  override def nextState(controller: GameController): Unit = {
    controller.setState(new Resetting)
  }

  override def handle(): Unit = {
    //    + Hacer que una unidad ataque a otra.

    //  + Hacer que un mago conjure un hechizo

  }

}