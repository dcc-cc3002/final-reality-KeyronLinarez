package Armas
/**
 * Represents a bow
 *
 * @param name The name of the bow.
 * @param attack  The attack life of the bow.
 * @param weight  The weight of the bow.
 * @param owner  The owner of the bow.
 *
 * @constructor Creates a new bow with the specified attributes.
 *
 */
class Bow(val name: String = "Bow", var attack: Int = 15, var weight: Double = 0.5,
          var owner: String = "") extends Weapon{

}
