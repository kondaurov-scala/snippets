package snippets.helper

import com.github.kondaurovdev.snippets.lang.ProductHelper
import org.specs2.mutable.Specification
import snippets.fake.Offer

class ProductHelperSpec extends Specification {

  val helper = new ProductHelper {}

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
