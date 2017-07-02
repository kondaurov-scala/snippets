package com.github.kondaurovdev.snippets.lang

import com.github.kondaurovdev.snippets.{TryHelper, iTryHelper}

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future => ScalaFuture}

trait iFutureHelper {

  def tryHelper: iTryHelper

  def waitFuture[F](f: ScalaFuture[F], sec: Int = 1)(implicit ec: ExecutionContext): Either[String, F] = {
    tryHelper.tryBlock({
      Await.result(f, sec.seconds)
    }, "can't get result of future")
  }

}

class FutureHelper extends iFutureHelper {
  val tryHelper = new TryHelper()
}
