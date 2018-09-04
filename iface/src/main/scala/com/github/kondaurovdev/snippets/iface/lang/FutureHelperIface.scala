package com.github.kondaurovdev.snippets.iface.lang

import scala.concurrent.Future

trait FutureHelperIface {

  def waitFuture[F](f: Future[F], sec: Int): Either[String, F]

}
