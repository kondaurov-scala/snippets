package com.github.kondaurovdev.snippets.text

trait iPrettyHelper {

  def clearBad(str: String): String = {

    val spacesRegex = """\s{2,}"""
    val controlSymsRegex = """(\n|\r)""".r
    val step1 = controlSymsRegex.replaceAllIn(str, " ")

    step1.replaceAll(spacesRegex, " ").trim

  }

  def trimBad(s: String, badRegex: String = """["\s]*"""): String = {
    var result = ("^" + badRegex).r.replaceFirstIn(s, "")
    result = (badRegex + "$").r.replaceFirstIn(result, "")
    result
  }

}

class PrettyHelper extends iPrettyHelper