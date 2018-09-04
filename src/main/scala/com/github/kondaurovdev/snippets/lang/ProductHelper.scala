package com.github.kondaurovdev.snippets.lang

import com.github.kondaurovdev.snippets.iface.lang.ProductHelperIface

trait iProductHelper extends ProductHelperIface {

  def ccToMap[T <: Product](cc: T): Map[String, Any] = {
    val values = cc.productIterator
    cc.getClass.getDeclaredFields.take(cc.productArity).map(f => f.getName -> values.next()).toMap
  }

}

object ProductHelper {
  def apply(): ProductHelper = new ProductHelper()
}

class ProductHelper extends iProductHelper
