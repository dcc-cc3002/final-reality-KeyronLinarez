package Armas
/**
 * Represents a  Sword
 *
 * @param name The name of the sword.
 * @param attack  The attack life of the sword.
 * @param weight  The weight of the sword.
 * @param owner  The owner of the sword.
 *
 * @constructor Creates a new sword with the specified attributes.
 *
 */
class Sword (val name: String = "Sword", var attack: Int = 20, var weight: Double = 1.0,
             var owner: String = "") extends Weapon{

}
