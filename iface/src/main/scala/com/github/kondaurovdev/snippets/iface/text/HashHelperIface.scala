package com.github.kondaurovdev.snippets.iface.text

trait HashHelperIface {

  /**
    * Get md5 hash of string
    * @param s
    * @return
    */
  def getMd5(s: String): Either[String, String]

}
