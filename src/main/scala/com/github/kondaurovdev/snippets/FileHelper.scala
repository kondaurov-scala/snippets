package com.github.kondaurovdev.snippets

import java.io._

import scala.io.Source

trait FileHelper extends TryHelper {

  def listFiles(dir: String): List[String] = {

    new File(dir).listFiles().filter(f => f.isFile ).map { f =>
      f.getName
    }.toList

  }

  def getFileNameWithoutExt(fileName: String): String = {

    val dot = fileName.lastIndexOf('.')

    if (dot != -1) {
      fileName.substring(0, dot)
    } else {
      fileName
    }

  }

  def fileExists(path: String): Boolean = {

    tryBlock({
      new File(path).exists()
    }).fold(
      _ => false,
      res => res
    )

  }

  def readFile(file: String, enc: String = "UTF-8"): Either[String, String] = {

    tryBlock({
      if (file.startsWith("http")) {
        Source.fromURL(file, enc).mkString
      } else {
        Source.fromFile(file, enc).mkString
      }
    }, s"Can't get content of file: $file")

  }

  def createDir(path: String): Either[String, String] = {
    tryBlock({
      new File(path).mkdirs()
      "Dir has been created"
    }, s"Can't create dir: $path")
  }

}

private object FileHelper extends FileHelper