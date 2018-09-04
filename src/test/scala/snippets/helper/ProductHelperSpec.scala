package snippets.helper

import org.specs2.mutable.Specification
import snippets.fake.Offer

import snippets.Snippets

class ProductHelperSpec extends Specification {

  val helper = Snippets.Lang.Product

  "CommonHelper" should {

    "ccToMap" in {

      "case 1" in {

        helper.ccToMap(Offer("asd", 5)) must beEqualTo(Map(
          "model" -> "asd",
          "count" -> 5
        ))

      }

    }

  }

}
