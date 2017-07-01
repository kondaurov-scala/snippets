package com.github.kondaurovdev.snippets.text

import scala.collection.mutable.ListBuffer

trait SymbolCase {

  def cameCaseToSnakeCase(s: String): String = {

    val result = ListBuffer.empty[Char]

    s.zipWithIndex.foreach {
      case (c, i) => if (c.isUpper) {
        if (result.lastOption.exists(_.isLower)) result ++= Seq('_', c.toLower)
      } else {
        result += c.toLower
      }
    }

    result.mkString

  }

  def snakeCaseToCamelCase(s: String): String = {

    val result = ListBuffer.empty[Char]

    s.foreach(c => {
      if (result.lastOption.contains('_')) {
        result += c.toUpper
      } else {
        result += c
      }
    })

    result.filterNot(c => c == '_').mkString

  }

}

object SymbolCase extends SymbolCase
