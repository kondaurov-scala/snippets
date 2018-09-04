package snippets.helper.text

import org.specs2.mutable.Specification

import snippets.Snippets

class LetterCaseSpec extends Specification {

  val symbolCase = Snippets.Text.LetterCase

  "SymbolCase" should {

    "camelCase2SnakeCase test" in {

      symbolCase.cameCaseToSnakeCase("accountId") must beEqualTo("account_id")
      symbolCase.cameCaseToSnakeCase("mySuperColumn") must beEqualTo("my_super_column")

    }

    "snakeCase2CamelCase test" in {

      symbolCase.snakeCaseToCamelCase("account_id") must beEqualTo("accountId")
      symbolCase.snakeCaseToCamelCase("my_super_column") must beEqualTo("mySuperColumn")

    }

  }

}
