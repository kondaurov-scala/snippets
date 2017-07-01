package snippets.helper.text

import com.github.kondaurovdev.snippets.text.{Pretty, SymbolCase}
import org.specs2.mutable.Specification

class PrettySpec extends Specification {

  val pretty = new Pretty {}

  "Pretty" should {

    "clearStr" in {

      "case 1" in {

        pretty.clearStr("\r\nBla \r\n equal\n\r1") must beEqualTo("Bla equal 1")

      }

    }

    "trimSpaces" in {

      "case 1" in {
        pretty.trimBad(" bla") must beEqualTo("bla")
      }

      "case 2" in {
        pretty.trimBad(" bla  ") must beEqualTo("bla")
      }

      "case 3" in {
        pretty.trimBad("bla  ") must beEqualTo("bla")
      }

    }

  }

}
