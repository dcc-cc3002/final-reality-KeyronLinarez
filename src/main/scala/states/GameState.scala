package states

import gamecontroller.GameController

trait GameState {
  def nextState(controller: GameController): Unit
  def handle(): Unit

}