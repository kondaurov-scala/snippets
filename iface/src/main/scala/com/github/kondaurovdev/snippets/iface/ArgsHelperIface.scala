package com.github.kondaurovdev.snippets.iface

trait ArgsHelperIface {

  def parseArgs(args: Iterable[String]): Seq[(String, Option[String])]

}
