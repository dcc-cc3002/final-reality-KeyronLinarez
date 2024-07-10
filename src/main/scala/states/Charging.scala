package states
import gamecontroller.GameController

class Charging extends AState {
  override def nextState(controller: GameController): Unit = {
    controller.setState(new Attacking)
  }
  override def handle(): Unit = {
    // increment every action bar by 10
    scheduler.incrementTurnPoints(10)
    scheduler.turnCheckAll()
  }




}