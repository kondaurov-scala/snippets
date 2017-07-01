package snippets.helper

import com.github.kondaurovdev.snippets.CommonHelper
import org.specs2.mutable.Specification
import snippets.fake.Offer

class CommonHelperSpec extends Specification {

  val helper = new CommonHelper {}

  "CommonHelper" should {

    "ccToMap" in {

      "case 1" in {

        helper.ccToMap(Offer("asd", 5)) must beEqualTo(Map(
          "model" -> "asd",
          "count" -> 5
        ))

      }

    }

    "parseArgs" in {

      helper.parseArgs(List(
        "config=someValue",
        "bla",
        "otherOpt=asd"
      )) must beEqualTo(Seq(
        "config" -> Some("someValue"),
        "bla" -> None,
        "otherOpt" -> Some("asd")
      ))

    }

  }

}
