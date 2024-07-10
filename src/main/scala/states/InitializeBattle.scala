package states
import gamecontroller.GameController

class InitializeBattle extends AState {
  // the state following initializing will be the CHARGING state
  override def nextState(controller: GameController): Unit = {
    controller.setState(new Charging)
  }

  override def handle(): Unit = {
    // add every character from a party into the turn scheduler
    for (character <- myParty.party_list) {
      scheduler.addCharacter(character)
    }
  }
}
