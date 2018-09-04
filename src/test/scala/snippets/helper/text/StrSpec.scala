package snippets.helper.text

import com.github.kondaurovdev.snippets.text.PrettyHelper
import org.specs2.mutable.Specification

import snippets.Snippets

class StrSpec extends Specification {

  val pretty = Snippets.Text.Pretty

  "Pretty" should {

    "clearStr" in {

      "case 1" in {

        pretty.clearBad("\r\nBla \r\n equal\n\r1") must beEqualTo("Bla equal 1")

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
