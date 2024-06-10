package gamecontroller

trait GameState {
  def creatingParty(): Unit
  def waitingZone(): Unit
  def attacking(): Unit
  def defeated(): Unit

}