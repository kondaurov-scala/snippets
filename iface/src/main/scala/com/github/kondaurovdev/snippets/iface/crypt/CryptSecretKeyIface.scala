package com.github.kondaurovdev.snippets.iface.crypt

import javax.crypto.spec.SecretKeySpec

trait CryptSecretKeyIface {

  def getSecretKey(myKey: String): Either[String, SecretKeySpec]

}
