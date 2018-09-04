package com.github.kondaurovdev.snippets.iface.lang

trait ProductHelperIface {

  def ccToMap[T <: Product](cc: T): Map[String, Any]

}
