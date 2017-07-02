package com.github.kondaurovdev.snippets.lang

trait iProductHelper {

  def ccToMap[T <: Product](cc: T): Map[String, Any] = {
    val values = cc.productIterator
    cc.getClass.getDeclaredFields.take(cc.productArity).map(f => f.getName -> values.next()).toMap
  }

}

class ProductHelper extends iProductHelper
