package snippets.helper.text

import org.specs2.mutable.Specification

import snippets.Snippets

class EncodeSpec extends Specification {

  val encoder = Snippets.Text.Encode

  "Encode" should {

    "getBase64" in {

      "case 1" in {
        encoder.getBase64FromString("alex") must beEqualTo("YWxleA==")
      }

      "case 2" in {
        encoder.getBase64FromString("утф8") must beEqualTo("0YPRgtGEOA==")
      }

    }

    "getFromBase64" in {

      "case 1" in {
        encoder.decodeBase64ToString("YWxleA==") must beRight("alex")
      }

      "case 2" in {
        encoder.decodeBase64ToString("0YPRgtGEOA==") must beRight("утф8")
      }

    }

  }

}
