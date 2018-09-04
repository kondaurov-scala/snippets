package snippets.helper.text

import org.specs2.mutable.Specification

import snippets.Snippets

class HashSpec extends Specification {

  val hash = Snippets.Text.Hash

  "Hash" should {

    "getMd5" in {

      "case1" in {
        hash.getMd5("123") must beRight("202cb962ac59075b964b07152d234b70")
      }

      "case2" in {
        hash.getMd5("bla") must beRight("128ecf542a35ac5270a87dc740918404")
      }

      "case3" in {
        hash.getMd5("com.github.kondaurovdev.json.valTypes.definitions.SchemaDef") must beRight("00ca6f749bc65357315b453e502b9ea1")
      }

    }

  }

}
