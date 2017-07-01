package com.github.kondaurovdev.snippets.crypt

import java.security.MessageDigest
import java.util
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

import com.github.kondaurovdev.snippets.TryHelper
import com.github.kondaurovdev.snippets.text.Encode

object Crypter {

  def getSecretKey(myKey: String): Either[String, SecretKeySpec] = {
    TryHelper.tryBlock({
      var key = myKey.getBytes("UTF-8")
      val sha = MessageDigest.getInstance("SHA-1")
      key = sha.digest(key)
      key = util.Arrays.copyOf(key, 16) // use only first 128 bit
      new SecretKeySpec(key, "AES")
    }, "Can't build secretKey")
  }

  def apply(secret: String): Either[String, Crypter] = {
    for (
      s <- getSecretKey(secret).left.map(err => s"Can't get secretKeySpec: $err").right
    ) yield new Crypter(s)
  }

}

class Crypter(secretKey: SecretKeySpec) {

  def encrypt(input: String): Either[String, String] = {

    TryHelper.tryBlock({
      val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
      cipher.init(Cipher.ENCRYPT_MODE, secretKey)
      val encrypted = cipher.doFinal(input.getBytes("UTF-8"))
      Encode.getBase64FromBytes(encrypted)
    }, "Can't encrypt text")

  }

  def decrypt(input: String): Either[String, String] = {

    for (
      decoded <- Encode.decodeBase64ToBytes(input).right;
      res <- {
        TryHelper.tryBlock({
          val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
          cipher.init(Cipher.DECRYPT_MODE, secretKey)
          val decrypted = cipher.doFinal(decoded)
          new String(decrypted, "UTF-8")
        }, "Error while decrypting")
      }.right
    ) yield res

  }


}
