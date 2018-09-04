package snippets.helper

import org.specs2.mutable.Specification

import snippets.Snippets

class TryHelperSpec extends Specification {

  val helper = Snippets.Try

  "TryHelper" should {

    "tryBlock" in {

      "case 1" in {
        helper.tryBlock({
          throw new Exception("blabla")
        }, "my error") must beLeft("my error: blabla")
      }

    }

  }

}
