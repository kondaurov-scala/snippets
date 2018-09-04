package com.github.kondaurovdev.snippets.iface.text

trait EncodeHelperIface {

  def getBase64FromBytes(b: Array[Byte]): String

  def getBase64FromString(s: String): String

  def decodeBase64ToString(base64: String): Either[String, String]

  def decodeBase64ToBytes(base64: String): Either[String, Array[Byte]]

}