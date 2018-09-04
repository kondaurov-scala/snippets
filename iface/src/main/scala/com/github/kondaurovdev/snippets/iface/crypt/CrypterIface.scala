package com.github.kondaurovdev.snippets.iface.crypt

trait CrypterIface {

  def encrypt(input: String): Either[String, String]

  def decrypt(input: String): Either[String, String]

}
