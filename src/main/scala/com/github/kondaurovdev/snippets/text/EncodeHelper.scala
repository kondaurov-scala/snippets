package com.github.kondaurovdev.snippets.text

import java.nio.charset.StandardCharsets

import com.github.kondaurovdev.snippets.{TryHelper, iTryHelper}
import org.apache.commons.codec.binary.Base64

trait iEncodeHelper {

  def tryHelper: iTryHelper

  def getBase64FromBytes(b: Array[Byte]): String = {
    Base64.encodeBase64String(b)
  }

  def getBase64FromString(s: String): String = {
    Base64.encodeBase64String(s.getBytes(StandardCharsets.UTF_8))
  }

  def decodeBase64ToString(base64: String): Either[String, String] = {
    tryHelper.tryBlock({
      val bytes = Base64.decodeBase64(base64.getBytes(StandardCharsets.UTF_8))
      new String(bytes)
    })
  }

  def decodeBase64ToBytes(base64: String): Either[String, Array[Byte]] = {
    tryHelper.tryBlock({
      Base64.decodeBase64(base64.getBytes(StandardCharsets.UTF_8))
    })
  }

}

class EncodeHelper() extends iEncodeHelper {

  val tryHelper = new TryHelper

}
