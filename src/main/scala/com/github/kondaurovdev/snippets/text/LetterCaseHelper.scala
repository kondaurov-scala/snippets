package com.github.kondaurovdev.snippets.text

import com.github.kondaurovdev.snippets.iface.text.LetterCaseIface

import scala.collection.mutable.ListBuffer

trait iLetterCaseHelperImpl extends LetterCaseIface {

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

class LetterCaseHelper extends iLetterCaseHelperImpl
