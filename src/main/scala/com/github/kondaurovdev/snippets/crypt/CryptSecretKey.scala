package com.github.kondaurovdev.snippets.crypt

import java.security.MessageDigest
import java.util
import javax.crypto.spec.SecretKeySpec

import com.github.kondaurovdev.snippets.iface.TryHelperIface
import com.github.kondaurovdev.snippets.iface.crypt.CryptSecretKeyIface

trait iCryptSecretKeyImpl extends CryptSecretKeyIface {

  def tryHelper: TryHelperIface

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

class CryptSecretKey(
                     val tryHelper: TryHelperIface
                     ) extends iCryptSecretKeyImpl
