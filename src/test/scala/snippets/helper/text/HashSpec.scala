package snippets.helper.text

import com.github.kondaurovdev.snippets.text.{Hash, SymbolCase}
import org.specs2.mutable.Specification

class HashSpec extends Specification {

  val hash = new Hash {}

  "Hash" should {

    "getMd5" in {

      "case1" in {
        hash.getMd5("123") must beEqualTo("202cb962ac59075b964b07152d234b70")
      }

      "case2" in {
        hash.getMd5("bla") must beEqualTo("128ecf542a35ac5270a87dc740918404")
      }

      "case3" in {
        hash.getMd5("com.github.kondaurovdev.json.valTypes.definitions.SchemaDef") must beEqualTo("00ca6f749bc65357315b453e502b9ea1")
      }

    }

  }

}
