package snippets

import org.specs2.mutable.Specification

import snippets.Snippets.Crypt

class CrypterSpec extends Specification {

  "Crypter" should {

    val crypter = Crypt.Crypter

    "decrypt" in {

      "case 1" in {
        crypter.decrypt("bVkPlx7E0OjhCWFyIHzM5Q==") must beRight("asd")
      }

    }

    "encrypt" in {

      "case 1" in {
        crypter.encrypt("asd") must beRight("bVkPlx7E0OjhCWFyIHzM5Q==")
      }

    }

  }

}
