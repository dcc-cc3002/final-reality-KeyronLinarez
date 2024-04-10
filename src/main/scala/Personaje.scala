/** Keyron Linares - Entrega Parcial 1 */
trait Personaje {
  val name: String
  var life: Double
  var defense: Double
  var weight: Double
  val classType: String
}

abstract class PersonajeFunciones (val name: String,
                                   var life: Double,
                                   var defense: Double,
                                   var weight: Double,
                                   val classType: String) extends Personaje{
  def getName(): String = name
  def getLife(): Double = life
  def getDefense(): Double = defense
  def getWeight(): Double = weight
  def getClassName(): String = classType

  // def equipArma(): Unit = Arma
  // def calcularTurno(): Double = ActionBar
  // ^^^ Uso interfaces que no he escrito todavia

   // Auxilary constructor for magic characters - includes mana*/
    def this(name: String, life: Double, defense: Double,
             weight: Double, class_type: String, mana: Double) = this(name, life, defense, weight, class_type)

}



// Class types:
class Paladines(name: String, life: Double, defense: Double,
                weight: Double, classType: String) extends PersonajeFunciones(name, life, defense, weight, classType){

}

class Guerreros(name: String, life: Double, defense: Double,
                weight: Double, classType: String) extends PersonajeFunciones(name, life, defense, weight, classType){

}

class Ninjas(name: String, life: Double, defense: Double,
                weight: Double, classType: String) extends PersonajeFunciones(name, life, defense, weight, classType){

}

class MagosNegros(name: String, life: Double, defense: Double,
                  weight: Double, classType: String, mana: Double) extends PersonajeFunciones(name, life, defense, weight, classType, mana){

}

class MagosBlancos(name: String, life: Double, defense: Double,
                   weight: Double, classType: String, mana: Double) extends PersonajeFunciones(name, life, defense, weight, classType, mana){

}
