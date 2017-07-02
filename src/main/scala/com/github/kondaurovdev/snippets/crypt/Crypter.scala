package com.github.kondaurovdev.snippets.crypt

import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

import com.github.kondaurovdev.snippets.text.{EncodeHelper, iEncodeHelper}

trait iCrypter {

  def secretKey: Either[String, SecretKeySpec]

  def cryptHelper: iCryptHelper

  def encodeHelper: iEncodeHelper

  def encrypt(input: String): Either[String, String] = {

    for (
      key <- secretKey;
      res <- {
        cryptHelper.tryHelper.tryBlock({
          val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
          cipher.init(Cipher.ENCRYPT_MODE, key)
          val encrypted = cipher.doFinal(input.getBytes("UTF-8"))
          encodeHelper.getBase64FromBytes(encrypted)
        }, "Can't encrypt text")
      }
    ) yield res

  }

  def decrypt(input: String): Either[String, String] = {

    for (
      key <- secretKey;
      decoded <- encodeHelper.decodeBase64ToBytes(input);
      res <- {
        cryptHelper.tryHelper.tryBlock({
          val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
          cipher.init(Cipher.DECRYPT_MODE, key)
          val decrypted = cipher.doFinal(decoded)
          new String(decrypted, "UTF-8")
        }, "Error while decrypting")
      }
    ) yield res

  }

}

class Crypter(key: String) extends iCrypter {

  val cryptHelper = new CryptHelper()

  lazy val secretKey: Either[String, SecretKeySpec] = cryptHelper.getSecretKey(key)

  lazy val encodeHelper: iEncodeHelper = new EncodeHelper

}

