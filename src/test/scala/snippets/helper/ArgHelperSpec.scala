package snippets.helper

import com.github.kondaurovdev.snippets.{ArgsHelper, iArgsHelper}
import org.specs2.mutable.Specification
import snippets.fake.Offer

class ArgHelperSpec extends Specification {

  val helper = new ArgsHelper

  "ArgHelper" should {

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
