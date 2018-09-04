package com.github.kondaurovdev.snippets.iface

trait FileHelperIface {

  def listFiles(dir: String): List[String]

  def getFileNameWithoutExt(fileName: String): String

  def fileExists(path: String): Boolean

  def readFile(file: String, enc: String): Either[String, String]

  def createDir(path: String): Either[String, String]

}
