package com.github.kondaurovdev.snippets.lang

import com.github.kondaurovdev.snippets.iface.TryHelperIface
import com.github.kondaurovdev.snippets.iface.lang.FutureHelperIface

import scala.concurrent.duration._
import scala.concurrent.{Await, Future => ScalaFuture}

trait iFutureHelperImpl extends FutureHelperIface {

  def tryHelper: TryHelperIface

  def waitFuture[F](f: ScalaFuture[F], sec: Int = 1): Either[String, F] = {
    tryHelper.tryBlock({
      Await.result(f, sec.seconds)
    }, "can't get result of future")
  }

}

class FutureHelper(
                  val tryHelper: TryHelperIface
                  ) extends iFutureHelperImpl
