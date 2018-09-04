package snippets.helper

import org.specs2.mutable.Specification

import snippets.Snippets

class ArgHelperSpec extends Specification {

  val helper = Snippets.Args

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
