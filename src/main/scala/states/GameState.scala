package states

trait GameState {
  def initializeBattle(): Unit
  def creatingParty(): Unit
  def waitingZone(): Unit
  def attacking(): Unit
  def defeated(): Unit

}