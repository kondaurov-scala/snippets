package com.github.kondaurovdev.snippets

import scala.collection.mutable

trait CommonHelper {

  def ccToMap[T <: Product](cc: T): Map[String, Any] = {
    val values = cc.productIterator
    cc.getClass.getDeclaredFields.take(cc.productArity).map(f => f.getName -> values.next()).toMap
  }

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

private object CommonHelper extends CommonHelper
