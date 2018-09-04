package com.github.kondaurovdev.snippets.iface.text

trait LetterCaseIface {

  /**
    * Convert fooBar to foo_bar
    * @param s
    * @return
    */
  def cameCaseToSnakeCase(s: String): String

  /**
    * Convert foo_bar to fooBar
    * @param s
    * @return
    */
  def snakeCaseToCamelCase(s: String): String

}
