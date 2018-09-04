package com.github.kondaurovdev.snippets.crypt

import javax.crypto.Cipher

import com.github.kondaurovdev.snippets.iface.TryHelperIface
import com.github.kondaurovdev.snippets.iface.crypt.CryptSecretKeyIface
import com.github.kondaurovdev.snippets.iface.text.EncodeHelperIface

trait iCrypterImpl {

  def secretKey: String

  def cryptSecretKey: CryptSecretKeyIface

  def encodeHelper: EncodeHelperIface

  def tryHelper: TryHelperIface

  def encrypt(input: String): Either[String, String] = {

    for {
      key <- cryptSecretKey.getSecretKey(secretKey)
      res <- {
        tryHelper.tryBlock({
          val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
          cipher.init(Cipher.ENCRYPT_MODE, key)
          val encrypted = cipher.doFinal(input.getBytes("UTF-8"))
          encodeHelper.getBase64FromBytes(encrypted)
        }, "Can't encrypt text")
      }
    } yield res

  }

  def decrypt(input: String): Either[String, String] = {

    for {
      key <- cryptSecretKey.getSecretKey(secretKey)
      decoded <- encodeHelper.decodeBase64ToBytes(input)
      res <- {
        tryHelper.tryBlock({
          val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
          cipher.init(Cipher.DECRYPT_MODE, key)
          val decrypted = cipher.doFinal(decoded)
          new String(decrypted, "UTF-8")
        }, "Error while decrypting")
      }
    } yield res

  }

}

class Crypter(
             val secretKey: String,
             val cryptSecretKey: CryptSecretKeyIface,
             val encodeHelper: EncodeHelperIface,
             val tryHelper: TryHelperIface
             ) extends iCrypterImpl

