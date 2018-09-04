package com.github.kondaurovdev.snippets.iface.text

trait PrettyHelperIface {

  def clearBad(str: String): String

  def trimBad(s: String, badRegex: String): String

}
