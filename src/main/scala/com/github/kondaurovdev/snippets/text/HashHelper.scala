package com.github.kondaurovdev.snippets.text

trait iHashHelper {

  def getMd5(s: String): String = {
    val m = java.security.MessageDigest.getInstance("MD5")
    val b = s.getBytes("UTF-8")
    m.update(b, 0, b.length)
    var res = new java.math.BigInteger(1, m.digest()).toString(16)
    while (res.length < 32) res = s"0$res"
    res
  }

}

class HashHelper extends iHashHelper