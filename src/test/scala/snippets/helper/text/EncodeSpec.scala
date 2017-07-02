package snippets.helper.text

import com.github.kondaurovdev.snippets.text.EncodeHelper
import org.specs2.mutable.Specification

class EncodeSpec extends Specification {

  val encode = new EncodeHelper {}

  "Encode" should {

    "getBase64" in {

      "case 1" in {
        encode.getBase64FromString("alex") must beEqualTo("YWxleA==")
      }

      "case 2" in {
        encode.getBase64FromString("утф8") must beEqualTo("0YPRgtGEOA==")
      }

    }

    "getFromBase64" in {

      "case 1" in {
        encode.decodeBase64ToString("YWxleA==") must beRight("alex")
      }

      "case 2" in {
        encode.decodeBase64ToString("0YPRgtGEOA==") must beRight("утф8")
      }

    }

  }

}
