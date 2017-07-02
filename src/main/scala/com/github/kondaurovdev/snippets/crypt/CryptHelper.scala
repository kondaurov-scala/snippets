package com.github.kondaurovdev.snippets.crypt

import java.security.MessageDigest
import java.util
import javax.crypto.spec.SecretKeySpec

import com.github.kondaurovdev.snippets.{TryHelper, iTryHelper}

trait iCryptHelper {

  def tryHelper: iTryHelper

  def getSecretKey(myKey: String): Either[String, SecretKeySpec] = {
    tryHelper.tryBlock({
      var key = myKey.getBytes("UTF-8")
      val sha = MessageDigest.getInstance("SHA-1")
      key = sha.digest(key)
      key = util.Arrays.copyOf(key, 16) // use only first 128 bit
      new SecretKeySpec(key, "AES")
    }, "Can't build secretKey")
  }

}

class CryptHelper extends iCryptHelper {

  lazy val tryHelper = new TryHelper

}
