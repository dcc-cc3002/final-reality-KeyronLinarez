package Armas


// Define a concrete class that implements the Weapon trait
class Axe(val name: String = "Axe", var attack: Int = 25, var weight: Double = 3.0,
          var owner: String = "") extends Weapon {
  // Additional methods specific to Sword can go here
}
