package snippets.fake

object Animal {

  sealed trait iAnimal

  case class Tiger(name: String) extends iAnimal
  case class Cat(name: String) extends iAnimal

}

case class Animal(
                 tiger: Option[Animal.Tiger] = None,
                 cat: Option[Animal.Cat] = None)