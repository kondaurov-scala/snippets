package com.github.kondaurovdev.snippets.text

import com.github.kondaurovdev.snippets.iface.TryHelperIface
import com.github.kondaurovdev.snippets.iface.text.HashHelperIface

trait iHashHelperImpl extends HashHelperIface {

  def tryHelper: TryHelperIface

  def getMd5(s: String): Either[String, String] = {
    tryHelper.tryBlock({
      val m = java.security.MessageDigest.getInstance("MD5")
      val b = s.getBytes("UTF-8")
      m.update(b, 0, b.length)
      var res = new java.math.BigInteger(1, m.digest()).toString(16)
      while (res.length < 32) res = s"0$res"
      res
    }, "Can't get md5 of string")
  }

}

class HashHelper(
                val tryHelper: TryHelperIface
                ) extends iHashHelperImpl