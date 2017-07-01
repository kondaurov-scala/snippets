package snippets

import com.github.kondaurovdev.snippets.crypt.Crypter
import org.specs2.mutable.Specification

class CrypterSpec extends Specification {

  "Crypter" should {

    val crypter = Crypter("passwd")

    "decrypt" in {

      "case 1" in {
        crypter.right.flatMap(_.decrypt("bVkPlx7E0OjhCWFyIHzM5Q==")) must beRight("asd")
      }

    }

    "encrypt" in {

      "case 1" in {
        crypter.right.flatMap(_.encrypt("asd")) must beRight("bVkPlx7E0OjhCWFyIHzM5Q==")
      }

    }

  }

}
