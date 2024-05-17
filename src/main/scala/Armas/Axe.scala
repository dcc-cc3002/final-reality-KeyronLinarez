package Armas

/**
 * Represents a axe
 *
 * @param name The name of the axe.
 * @param attack  The attack life of the axe.
 * @param weight  The weight of the axe.
 * @param weapon  The owner of the axe.
 *
 * @constructor Creates a new axe with the specified attributes.
 *
 */
class Axe(val name: String = "Axe", var attack: Int = 25, var weight: Double = 3.0,
          var owner: String = "") extends Weapon {
}
