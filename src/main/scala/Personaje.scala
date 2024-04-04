/** Keyron Linares - Entrega Parcial 1 */
/** Cade personaje tiene un nombre, puntos de vida, defensa y pesofg */
class Personaje (private val name: String, private var life: Double, private var defense: Double,
                 private var weight: Double, private val class_type: String) {

  /* Auxilary constructor for magic characters - includes mana*/
  def this(name: String, life: Double, defense: Double,
           weight: Double, class_type: String, mana: Double) =
    this(name, life, defense, weight, class_type)


}
