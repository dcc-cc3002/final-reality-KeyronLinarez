package Characters

import Armas.Weapon

/** Keyron Linares - Entrega final 1 */
trait Character {
  private val name: String = "DefaultName"
  private var life: Int = 1
  private var defense: Int = 0
  private var weight: Double = 1

  def getName: String = name
  def getLife: Int = life
  def getDefense: Int = defense
  def getWeight: Double = weight
}

