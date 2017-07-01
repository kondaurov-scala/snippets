package snippets.helper

import com.github.kondaurovdev.snippets.TryHelper
import org.specs2.mutable.Specification

class TryHelperSpec extends Specification {

  val helper = new TryHelper {}

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
