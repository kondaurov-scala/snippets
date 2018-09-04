package com.github.kondaurovdev.snippets

import com.github.kondaurovdev.snippets.iface.ArgsHelperIface

import scala.collection.mutable

trait iArgsHelperImpl extends ArgsHelperIface {

  def parseArgs(args: Iterable[String]): Seq[(String, Option[String])] = {

    val result = mutable.ArrayBuffer.empty[(String, Option[String])]

    args.foreach(v => {
      v.split("=").toList match {
        case key :: value :: Nil => result += key -> Some(value)
        case key :: Nil => result += key -> None
        case _ =>
      }
    })

    result.result()

  }

}

class ArgsHelper() extends iArgsHelperImpl
