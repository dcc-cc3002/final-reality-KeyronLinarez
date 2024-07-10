package states
import gamecontroller.GameController

class GameOver extends AState {
  override def nextState(controller: GameController): Unit = {
    controller.setState(new InitializeBattle)
  }

  override def handle(): Unit = {
    // remove all characters from the party to prepare for new battle
    for (character <- myParty.party_list) {
      myParty.dropCharacter(character)
    }
  }


}