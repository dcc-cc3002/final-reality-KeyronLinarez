package states
import gamecontroller.GameController

class Resetting extends AState {

  def gameOver : Boolean = false
  override def nextState(controller: GameController): Unit = {
    if (gameOver){
      controller.setState(new GameOver)
    } else{
      // reset all action bars and empty the queue
      scheduler.resetStatus()
      scheduler.clearTurnQueue()
      controller.setState(new Charging)
    }
  }

  override def handle(): Unit = {
    for (character <- myParty.party_list) {
      // if character died during battle, retire character
      if (character.healthBar < 0) {
        scheduler.retireCharacter(character)
      }
    }
  }

}